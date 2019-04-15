import java.util.ArrayList;

/**
 * A "kilepo" csempe.
 */
public class ExitTile extends Tile {
    public boolean receiveAnimal(Animal a){
        ArrayList<Object> par = new ArrayList<>(); par.add(a);
        Logger.enter(this, "receiveAnimal", par);
        //TODO
        Logger.exit(this, "receiveAnimal", true);
        return true;
    }
}
