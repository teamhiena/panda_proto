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
	public GameMap() {
		listGetterMap.put(Key.WeakTile, new ArrayList<Tile>());
		listGetterMap.put(Key.Arcade, new ArrayList<Tile>());
		listGetterMap.put(Key.Automat, new ArrayList<Tile>());
		listGetterMap.put(Key.Fotel, new ArrayList<Tile>());
		
		listGetterMap.put(Key.Wardrobe, new ArrayList<Tile>());
		listGetterMap.put(Key.WardrobeExit, new ArrayList<Tile>());
		//listGetterMap.put(Key.Orangutan, new ArrayList<>()); //TODO kiszedni orangutanos Tile-okat

		//Ideiglenes, orangutan won-hoz egy Orangutant felolvas!
		//Tile t = new Tile(); t. setAnimal(new Orangutan(new Game()));
		//listGetterMap.get(Key.Orangutan).add(t);
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
		//Orangutan
	}

	/**
	 * Visszater egy veletlenszeruen kivalasztott szekreny kijarattal.
	 */
	public Tile getRandomWardrobeExitTile() {
		Random rng = new Random();
		ArrayList<Tile> exits=getSpecificTiles(Key.WardrobeExit);
		if (exits.size()<2)
			return null;
		Integer idx=rng.nextInt(exits.size());
		Tile ret=exits.get(idx);
		//System.out.println(idx);
		return ret;
	}

	/**
	 * Visszaadja az exit csempet.
	 */
	public Tile getExitTile() { return exit; }

	/**
	 * Visszaadja a bejarat csempet
	 */
	public Tile getEntryTile() { return entry; }

	/**
	 * Visszaadja az parameterkent kapott tipusu csempeket.
	 */
	public ArrayList<Tile> getSpecificTiles(GameMap.Key key){
		ArrayList<Tile> ret = listGetterMap.get(key);
		return ret;
	}

	public void addSpecificTile(Tile t,Key key) {
		listGetterMap.get(key).add(t);
	}
	/**
	 * Visszaadja a gyenge csempeket.
	 */
	/*public ArrayList<WeakTile> getWeakTiles(){
		//erre valo a getSpecificTiles
		return new ArrayList<WeakTile>();
	}*/
	/**
	 * EntryTile adattag setter fuggvenye
	 */
	public void setEntry(EntryTile e){
		entry = e;
	}
	public void setExit(ExitTile e) {exit=e;}
}
