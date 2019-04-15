import java.util.ArrayList;

public class Game{
	private int numberofplayers = 1;
	private GameMode selectedMode;
	private GameMap map;
	private ArrayList<Orangutan> orangutans=new ArrayList<Orangutan>();

	/**
	 * A jatekmodok enumja.
	 */
	enum GameMode{
		FinitPanda,
		FinitTime
	}

	public void addOrangutan(Orangutan o) {
		ArrayList<Object> p=new ArrayList<>();
		Logger.enter(this,"addOrangutan",p);
		p.add(o);
		orangutans.add(o);
		Logger.exit(this, "addOrangutan", null);
	}
	public ArrayList<Orangutan> getOrangutans(){
		Logger.enter(this, "getOrangutans", new ArrayList<>());
		Logger.exit(this, "getOrangutans", null);
		return orangutans;
	}

	/**
	 * Jelenleg nincsen funkcioja.
	 */
	public void main() {
		Logger.enter(this, "main", new ArrayList<>());
		//TODO
		Logger.exit(this, "main", null);
	}

	/**
	 * Kezeli az orangutan kilepeset.
	 */
	//TODO: ez csak kilepteti az orangutant, de az ot koveto pandakat nem kezeli
	public void exiting(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "exiting", par);

		int num = o.getPandaNum(); //Az orangutant koveto pandak szama.
		if(num >= 5) 			   //Ha tobb mint 5.
			this.reward();
		o.increaseScore(num); 	   //Noveli az orangutan pontjait.
		o.goToEntry(); 		  	   //A bejarathoz helyezi az orangutant.

		Logger.exit(this, "exiting", null);
	}

	/**
	 * Kezeli a jutalmat 5 kivitt panda utan.
	 */
	public void reward() {
		Logger.enter(this, "reward", new ArrayList<>());

		this.weakTilesAddlife(); 				  //Noveli a gyenge csempek eleterejet.

		//Jatekmodtol fuggoen vagy csokkenti, vagy noveli az idot.
		if(selectedMode == GameMode.FinitPanda)
			Timer.instance().decreaseTime(5);
		if(selectedMode == GameMode.FinitTime)
			Timer.instance().increaseTime(5);

		Logger.exit(this, "reward", null);
	}

	/**
	 * Az elert pontszamot menti el.
	 */
	public void SaveHighScore(int s) {
		ArrayList<Object> par = new ArrayList<>(); par.add(s);
		Logger.enter(this, "SaveHighScore", par);

		//Itt meg csak kiirja a pontszamot.
		System.out.println("Current score: " + s);

		Logger.exit(this, "SaveHighScore", null);
	}

	/**
	 * A jatek vege, visszalep a fomenube.
	 */
	public void gameOver() {
		Logger.enter(this, "gamaOver", new ArrayList<>());
		//TODO
		Logger.exit(this, "gameOver", null);
	}

	/**
	 * Noveli a gyenge csempek eleterejet.
	 */
	public void weakTilesAddlife() {
		Logger.enter(this, "weakTilesAddlife", new ArrayList<>());

		/*ArrayList<WeakTile> weakTiles = GameMap.instance().getWeakTiles();
		for (WeakTile tl: weakTiles) {
			tl.reduceNumOfSteps();
		}*/

		Logger.exit(this, "weakTilesAddlife", null);
	}

	/**
	 * Visszaadja a valasztott jatekmodot. A selectedMode adattag gettter fuggvenye.
	 */
	public GameMode getSelectedMode() {
		return selectedMode;
	}

	/**
	 * Beallitja a valaszott jatekmodot. A selectedMode adattag setter fuggvenye.
	 */
	public void setSelectedMode(GameMode selectedMode) {
		this.selectedMode = selectedMode;
	}
}
