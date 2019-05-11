import java.util.ArrayList;

/**
 * A Jatekgepet(Arcade) megvalosito osztaly. Az objektumba nem lehet belepni.
 */
public class Arcade extends NonEnterableEntity{

	/**
	 * Minden, a kornyezo mezokon talalhato pandanak meghivja az affectedBy() fuggvenyet.
	 */
	@Override
	public void makeEffect() {
		ArrayList<Tile> al = this.getTile().getNeighbors();
		for (int i = 0; i < al.size(); i++) {
			Panda p = (Panda) al.get(i).getAnimal();
			if (al.get(i).getAnimal() != null) p.affectedBy(this);
		}

	}
}
