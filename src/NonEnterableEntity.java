import java.util.ArrayList;

/**
 * Azon osztalyokhoz tartozo absztrakt ososztaly, amelyekbe nem lehet belepni.
 */
public abstract class NonEnterableEntity extends Entity implements MakesEffect{

	/**
	 * Ertelemszeruen, ha egy ilyen osztalyba egy orangutan/panda probal belepni, ez nem lesz lehetseges.
	 */
	@Override
	public boolean stepIn(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "stepIn", par);
		Logger.exit(this, "stepIn", false);
		return false;
	}
	@Override
	public boolean stepIn(Panda p) {
		ArrayList<Object> par = new ArrayList<>(); par.add(p);
		Logger.enter(this, "stepIn", par);
		Logger.exit(this, "stepIn", false);
		return false;
	}
}
