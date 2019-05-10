import java.util.ArrayList;

/**
 * A "kilepo" csempe.
 */
public class ExitTile extends Tile {
    @Override
    public boolean receiveAnimal(Orangutan o) {
        if(o.followedBy != null) {
            o.increaseScore(10*o.getPandaNum());
            o.goToEntry();//  ha ez egyaltalan meg lesz csinalva
            Panda a = o.followedBy;
            if (a != null) {
                while (a != null) {
                    Panda b = a.followedBy;
                    a.setFollowing(null);
                    a.die();
                    a = b;
                }
            }
            o.releasePandas();
            //mi tortenik
            return true;
        }

        boolean success=false;
        if(entity!=null)//ha van ott entiy akk megprobalok belelepni
            success=entity.stepIn(o); //ha nem enterable vagy panda ul benne akk false
        else if(animal!=null) {
            success=animal.getCaughtBy(o);
        }
        return false;
    }
    @Override
    public boolean receiveAnimal(Panda p) {
        if(p.following != null) {
            p.die();
            p.release();
            return false;
        }
        boolean success=true;
        if(animal != null) { //ha van ott allat akk fix off
            return false;
        }
        else if (entity != null) { //ha van ott entity akkor attol fugg
            success = entity.stepIn(p);
        }
        if (success) {
            if(p.followedBy!=null)
                p.followedBy.setNextTile(p.tile);
            this.setAnimal(p);
            p.getTile().setAnimal(null);
            p.setTile(this);
        }
        return success;
    }
}
