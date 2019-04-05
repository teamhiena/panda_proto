import java.util.ArrayList;

/**
 * A csokiautomatat(Automat) megvalosito osztaly. Az osztalyba nem lehet belepni.
 */
public class Automat extends NonEnterableEntity{
	/**
	 * Minden, a kornyezo mezokon talalhato pandanak meghivja az affectedBy() fuggvenyet.
	 */
	@Override
	public void makeEffect() {
		Logger.enter(this, "makeEffect", new ArrayList<>());
		for(Panda sp: tile.getSubbedPandas())
			sp.affectedBy(this);
		Logger.exit(this, "makeEffect", null);
	}	
}
