import java.util.ArrayList;

public abstract class Animal implements Steppable{
    protected Tile tile; //Ezen all az allat.
    //protected Tile nextTile=null; //Ez lesz a kovetkezo mezo, amire lepni fog.
    protected Panda followedBy=null; //Ez az allat koveti.
    protected Animal following=null; //Ezt az allatot koveti.
    
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
        this.getTile().setAnimal(null);
        this.setTile(null);

    }
    /**
     * Tile adattag getter/setter fuggvenye.
     */
	public void setTile(Tile t) { tile = t; }
	public Tile getTile() { return tile; }
    /**
    * Following adattag setter fuggvenye.
    */
	public void setFollowing(Animal p) { following = p; }

    /**
     * isFollowing adattag getter/setter fuggvenye.
     */
    public boolean isFollowing() {
        return following != null;
    }
    /**
     * FollowedBy adattag setter fuggvenye.
     */
    public void setFollowedBy(Panda p) { followedBy = p; }

    /**
     * isFollowedBy adattag getter/setter fuggvenye.
     */
    public boolean isFollowedBy() {
        return followedBy != null;
    }

    //public void affectedBy(Entity e) {} //gombi szombat 21:24
    public void affectedBy(Arcade a){ } //gombi szombat 22:52
    public void affectedBy(Automat a) { } //gombi szombat 22:52

    /**
     * Az allatot elkapja egy Panda. Valojaban lehetetlen esemeny, de muszaj megvalositani.
     * @param p elkapo panda
     */
    public boolean getCaughtBy(Panda p){
        return false;
    }

    /**
     * Az allatot elkapja egy orangutan. Leszarmazottakban felulirando.
     */
    public abstract boolean getCaughtBy(Orangutan o);
    //public Tile getNextTile(){ return nextTile; }
    public Panda getFollowedBy(){ return followedBy; }
    public Animal getFollowing() { return following; }
}
