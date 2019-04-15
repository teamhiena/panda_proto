import java.util.ArrayList;

public abstract class Panda extends Animal{
	private ArrayList<Tile> subbedTiles=new ArrayList<Tile>();
	protected GameMap map; //TODO:inicializalni
	protected GameMap.Key hatesEntity;

	//METODUSOK
	public void affectedBy(Entity e) {
		//el tudom lepzelni hogy ennek semmi ertelme mert ugyis csak ugyanolyan parameterrel lehet overrideolni (G)
	}

	public void affectedBy(Arcade a){ }
	public void affectedBy(Automat a) { }
	public void affectedBy(Fotel f) { }
	/**
	 * Hozzaad egy csempet a panda subbedTiles listajahoz.
	 */

	public void addSubbedTile(Tile t) {
		ArrayList<Object> par = new ArrayList<>(); par.add(t);
		Logger.enter(this, "addSubbedTile", par);
		subbedTiles.add(t);
		Logger.exit(this, "addSubbedTile", null);
	}

	/**
	 * Kitorli a feliratkozott csempek listajat.
	 */
	public void clearSubbedTiles() {
		Logger.enter(this, "clearSubbedTiles", new ArrayList<>());
		subbedTiles.clear();
		Logger.exit(this, "clearSubbedTiles", null);
	}

	/**
	 * A tile adattag getter fuggvenye.
	 */
	public Tile getTile() {
		Logger.enter(this, "getTile", new ArrayList<>());
		Logger.exit(this, "getTile", tile);
		return tile;
	}

	/**
	 * A pandat a parameterben megadott mezore mozgatjuk.
	 */
	@Override
	public boolean step(Tile newTile) {
		ArrayList<Object> par = new ArrayList<>(); par.add(newTile);
		Logger.enter(this, "step", par);

		boolean success = newTile.receiveAnimal(this);
		if(success) {
			tile.removePandaFromNeighborSubbedPandas(this); //Panda eltavolitasa a szomszedokrol.
			subbedTiles.clear(); //Panda feliratkozasainak torlese
			for(Tile newTileNeighbor:newTile.getNeighbors()) { 
				if(map.getSpecificTiles(hatesEntity).contains(newTileNeighbor)) {
					addSubbedTile(newTileNeighbor); //Az uj helyen szomszedok felirasa pandara
					newTileNeighbor.addSubbedPanda(this); //Az uj helyen szomszedokra feliratkozasok
				}			
			}
			/*newTile.setAnimal(this);
			tile.setAnimal(null);
			tile=newTile;*/
		}

		Logger.exit(this, "step", success);
		return success;
	}

	/**
	 * A pandat "elkapja" a parameterben megadott orangutan.
	 */
	@Override
	public boolean getCaughtBy(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "getCaughtBy", par);
		
		if(isFollowing()) //Mar elkapott pandat nem kapunk el
		{
			Logger.exit(this, "getCaughtBy", false);
			return false;
		}
		
		//setIsFollowing(true);
		//setFollowing(o);
		if(o.isFollowedBy()){
			//setIsFollowedBy(true);
			setFollowedBy(o.followedBy);
			followedBy.setFollowing(this);			
		}
		o.setFollowedBy(this);
		//o.setIsFollowedBy(true);
		
		Logger.exit(this, "getCaughtBy", true);
		return true;
	}
	/**
	 * Elengedi az ot koveto ill. annak a pandanak a kezet akit o kovet.
	 */
	public void release()
	{
		following = null;
		//isFollowing = false;
		if(/*isFollowedBy*/followedBy!=null){
			followedBy.release();
		}
	}
	
	public void setNextTile(Tile t) {
		nextTile=t;
	}
}
