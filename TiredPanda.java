import java.util.ArrayList;

/**
 * A faradekony pandat(TiredPanda) megvalosito osztaly.
 */
public class TiredPanda extends Panda {

	//KONSTRUKTOROK
	public TiredPanda(GameMap gm) {
		hatesEntity=GameMap.Key.Fotel;
		map = gm;
	}

	//METODUSOK

	/**
	 * A Panda egy f Fotel hatasa ala kerul.
	 */
    public void affectedBy(Fotel f) {
		ArrayList<Object> par = new ArrayList<>(); par.add(f);
    	Logger.enter(this, "affectedBy", par);
    	//TODO
		//El kell helyeznie a sajat magat a mezon.
		tile.setAnimal(null);
		f.getTile().setAnimal(this);
		this.setTile(f.getTile());
		Logger.exit(this, "affectedBy", null);
    }
}
