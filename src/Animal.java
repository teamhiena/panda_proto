import java.util.ArrayList;

public abstract class Animal implements Steppable{
    protected Tile tile=null; //Ezen all az allat.
    protected Tile nextTile=null; //Ez lesz a kovetkezo mezo, amire lepni fog.
    protected Panda followedBy=null; //Ez az allat koveti.
    protected Panda following=null; //Ezt az allatot koveti.
    //protected boolean isFollowedBy = false; //Megadja, hogy koveti-e valakit.
    //protected boolean isFollowing = false; //Megadja, hogy kovet-e valakit.
    
    //KONSTRUKTOROK
    public Animal(Tile t) {
    	tile=t;
    }
    public Animal() {
    	tile=null;
    }
        
    //METODUSOKK

    /**
     * Ez a metodus hivodik meg, amikor az allat "meghal".
     */
    public void die(){
        Logger.enter(this, "die", new ArrayList<>());
        //TODO
        Logger.exit(this, "die", null);

    }
    /**
     * Tile adattag getter/setter fuggvenye.
     */
	public void setTile(Tile t) {
        ArrayList<Object> par = new ArrayList<>(); par.add(t);
        Logger.enter(this, "setTile", par);
		tile=t;
		Logger.exit(this, "setTile", null);
	}
	public Tile getTile() {
		return tile;
	}
    /**
    * Following adattag setter fuggvenye.
    */
	public void setFollowing(Panda p) {
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "setFollowing", par);
		following=p;
        Logger.exit(this, "setFollowing", null);
	}

    /**
     * isFollowing adattag getter/setter fuggvenye.
     */
    public boolean isFollowing() {
        Logger.enter(this, "isFollowing", new ArrayList<>());
        boolean ret = false;
        if(following != null) ret = true;
        Logger.exit(this, "isFollowing", ret);
        return ret;
    }
   /* public void setIsFollowing(boolean f){
       ArrayList<Object> par = new ArrayList<>(); par.add(f);
       Logger.enter(this, "setIsFollowing", par);
        isFollowing = f;
        Logger.exit(this, "setIsFollowing", null);
    }*/

    /**
     * FollowedBy adattag setter fuggvenye.
     */
    public void setFollowedBy(Panda p) {
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "setFollowedBy", par);
        followedBy = p;
        Logger.exit(this, "setFollowedBy", null);
    }

    /**
     * isFollowedBy adattag getter/setter fuggvenye.
     */
    public boolean isFollowedBy() {
        Logger.enter(this, "isFollowedBy", new ArrayList<>());
        boolean ret = false;
        if(followedBy!=null) ret = true;
        Logger.exit(this, "isFollowedBy", ret);
    	return ret;
    }
    /*public void setIsFollowedBy(boolean f){
        ArrayList<Object> par = new ArrayList<>(); par.add(f);
        Logger.enter(this, "setFollowedBy", par);
        isFollowedBy = f;
        Logger.exit(this, "setFollowedBy", null);
    }*/

    /**
     *
     */
    public void releaseFollowerRecursively() {
        Logger.enter(this, "releaseFollowerRecursively", new ArrayList<>());
        //TODO
        Logger.exit(this, "releaseFollowerRecursively", null);
    }

    /**
     * Az allatot elkapja egy Panda. Valojaban lehetetlen esemeny, de muszaj megvalositani.
     * @param p
     */
    public boolean getCaughtBy(Panda p){
        return false;
    }

    /**
     * Az allatot elkapja egy orangutan. Leszarmazottakban felulirando.
     */
    public abstract boolean getCaughtBy(Orangutan o);
}
