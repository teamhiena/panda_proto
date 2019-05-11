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

    /*public TiredPanda() {

    }*/

	//METODUSOK

	/**
	 * A Panda egy f Fotel hatasa ala kerul.
	 */
    public boolean affectedBy(Fotel f) {
    	//TODO mi van ha followoljak???

		//f.getTile().setAnimal(this);
		//tile.setAnimal(this);
		//tile=f.getTile();

		if (isFollowing())
			release();

		f.resetTimeLeft();
		f.setEnteredFrom(tile);
		return true;
    }
}
