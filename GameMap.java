import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;


public class GameMap {
	private static GameMap instance = null;
	private HashMap<GameMap.Key,ArrayList<Tile>> listGetterMap=new HashMap<GameMap.Key,ArrayList<Tile>>();
	private EntryTile entry = new EntryTile();
	private ExitTile exit = new ExitTile();

	//KONSTRUKTOROK
	private GameMap() {
		listGetterMap.put(Key.WeakTile, new ArrayList<>()); //TODO kiszedni a weakTile-t külön
		listGetterMap.put(Key.Arcade, new ArrayList<>());
		listGetterMap.put(Key.Automat, new ArrayList<>());
		listGetterMap.put(Key.Fotel, new ArrayList<>());
		listGetterMap.put(Key.Wardrobe, new ArrayList<>());
		listGetterMap.put(Key.WardrobeExit, new ArrayList<>());
		listGetterMap.put(Key.Orangutan, new ArrayList<>()); //TODO kiszedni orangutanos Tile-okat

		//Ideiglenes, orangutan won-hoz egy Orangutant felolvas!
		Tile t = new Tile(); t. setAnimal(new Orangutan(new Game()));
		listGetterMap.get(Key.Orangutan).add(t);
	}

	static public GameMap instance() {
		if (instance == null) instance = new GameMap();
		return instance;
	}

	public void finalize() {
		instance = null;
	}

	enum Key{
		WeakTile,
		Arcade,
		Automat,
		Fotel,
		Wardrobe,
		WardrobeExit,
		Orangutan
	}

	/**
	 * Visszater egy veletlenszeruen kivalasztott szekreny kijarattal.
	 */
	public Tile getRandomWardrobeExitTile() {
		Logger.enter(this, "getRandomWardrobeExitTile", new ArrayList<>());
		Random vel = new Random();
		Tile t = listGetterMap.get(Key.WardrobeExit).get(vel.nextInt(listGetterMap.get(Key.WardrobeExit).size()));
		Logger.exit(this, "getRandomWardrobeExitTile", t);
		return t;
	}

	/**
	 * Visszaadja az exit csempet.
	 */
	public Tile getExitTile() {
		Logger.enter(this, "getExitTile", new ArrayList<>());
		ExitTile t = exit;
		Logger.exit(this, "getExitTile", t);
		return t;
	}

	/**
	 * Visszaadja a bejarat csempet
	 */
	public Tile getEntryTile() {
		Logger.enter(this, "getEntryTile", new ArrayList<>());
		EntryTile t = entry;
		Logger.exit(this, "getEntryTile", t);
		return t;
	}

	/**
	 * Visszaadja az parameterkent kapott tipusu csempeket.
	 */
	public ArrayList<Tile> getSpecificTiles(GameMap.Key key){
		ArrayList<Object> par = new ArrayList<>(); par.add(key);
		Logger.enter(this, "getSpecificTiles", par);
		ArrayList<Tile> ret = listGetterMap.get(key);
		Logger.exit(this, "getSpecificTiles", null); //Mivel egy listat adunk, ezt nagyon nehez abrazolni
		return ret;
	}

	public void addSpecificTile(Tile t,Key key) {
		listGetterMap.get(key).add(t);
	}
	/**
	 * Visszaadja a gyenge csempeket.
	 */
	public ArrayList<WeakTile> getWeakTiles(){
		Logger.enter(this, "getWeakTiles", new ArrayList<>());
		//TODO
		Logger.exit(this, "getWeakTiles", null); //Mivel egy listat adunk, ezt nagyon nehez abrazolni
		return new ArrayList<WeakTile>();
	}
	/**
	 * EntryTile adattag setter fuggvenye
	 */
	public void setEntry(EntryTile e){
		entry = e;
	}
}
