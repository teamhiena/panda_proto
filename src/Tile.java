import java.util.ArrayList;
import java.util.Random;

public class Tile {
    //A Tile-on all-e valamilyen entitas (arcade, automat stb). Null eseten nem talalhato ilyen.
    protected Entity entity=null;
    //A Tile-on all-e Orangutan/Panda, null eseten nincs rajta semmi.
    protected Animal animal=null;
    //A Tile szomszedos Tile-jait tarolo lista
    private ArrayList<Tile> neighbors=new ArrayList<Tile>();
    //A Tile-ra feliratkozott pandak.
    private ArrayList<Panda> subbedPandas=new ArrayList<Panda>();

    //METODUSOK
    /**
     * A Tile-rol elenged egy Animalt, azaz ezutan ures.
     */
    public void releaseAnimal(){
        Logger.enter(this, "releaseAnimal", new ArrayList<>());
        animal=null;
        Logger.exit(this, "releaseAnimal", null);
    }
    /*
     * Beallitja az Animal-t a Tile-ra.
     */
    public void setAnimal(Animal a) {
        ArrayList<Object> par = new ArrayList<>(); par.add(a);
        Logger.enter(this, "setAnimal", par);
        animal=a;
        Logger.exit(this, "setAnimal", null);
    }
    /**
     * Atveszi a Pandat
     * Ha az adott Tile-on all allat, akkor nem veszi at az allatot
     * Ha az adott Tile-on entitas all, akkor az entitastol fugg, mi tortenik ott
     * (Fotel es Wardrobe eseten atveszi)
     * Ha nincs rajta semmi, akkor atveszi
     */
    public boolean receiveAnimal(Panda p) {
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "receiveAnimal", par);

        boolean success=true;
        if(animal != null) { //ha van ott allat akk fix off
            Logger.exit(this, "receiveAnimal", false);
            return false;
        }
        else if (entity != null) { //ha van ott entity akkor attol fugg
            success = entity.stepIn(p);
        }
        else if (entity == null){
            this.setAnimal(p);
            p.getTile().setAnimal(null);
            p.setTile(this);
        }
        Logger.exit(this, "receiveAnimal", success);
        return success;
    }

    public void setEntity(Entity e) {
        entity=e;
    }


    /**
     * Atveszi a Orangutant
     * Ha az adott Tile-on all allat, akkor nem veszi at az allatot
     * Ha az adott Tile-on entitas all, akkor az entitastol fugg, mi tortenik ott
     * (Fotel es Wardrobe eseten atveszi)
     * Ha nincs rajta semmi, akkor atveszi
     */

    public boolean receiveAnimal(Orangutan o) {
        ArrayList<Object> par = new ArrayList<>(); par.add(o);
        Logger.enter(this, "receiveAnimal", par);

        boolean success=true;
        if(entity != null)//Ha van ott entiy akk megprobalok belelepni.
            success = entity.stepIn(o); //Ha nem enterable vagy panda ul benne akkor false.
        else if(animal != null) {
            success=animal.getCaughtBy(o);
        }
        else if (entity == null){
            this.setAnimal(o);
            o.getTile().setAnimal(null);
            o.setTile(this);
        }

        //Nincs ott allat de olyan entity van amibe (most) nem lehet belelepni
        //pl nonenterableentity vagy egy hasznalatban levo fotel

        Logger.exit(this, "receiveAnimal", success);
        return success;
    }
    // Eltavolitja a Pandat a Tile szomszedos Tile-jainak feliratkozoi kozul
    public void removePandaFromNeighborSubbedPandas(Panda p) {
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "removePandaFromNeighborSubbedPandas", par);
        for(Tile nt:neighbors)
            nt.removeSubbedPanda(p);
        Logger.exit(this, "removePandaFromNeighborSubbedPandas", null);
    }
    // Panda feliratkozasa a Tile-ra
    public void addSubbedPanda(Panda p) {
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "addSubbedPanda", par);
        subbedPandas.add(p);
        Logger.exit(this, "removePandaFromNeighborSubbedPandas", null);
    }
    // Eltavolitja a pandat a feliratkozoi kozul
    public void removeSubbedPanda(Panda p) {
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "removeSubbedPanda", par);
        subbedPandas.remove(p);
        Logger.exit(this, "removeSubbedPanda", null);
    }
    // Visszaadja az entitast ami rajta all.
    public Entity getEntity() {
        Logger.enter(this, "getEntity", new ArrayList<>());
        Logger.exit(this, "getEntity", null);
        return entity;
    }
    // Visszaadja a szomszedos Tile-okat
    public ArrayList<Tile> getNeighbors(){
        Logger.enter(this, "getNeighbors", new ArrayList<>());
        Logger.exit(this, "getNeighbors", null);
        return neighbors;
    }
    // Visszaadja a feliratkozott pandakat
    public ArrayList<Panda> getSubbedPandas() {
        Logger.enter(this, "getSubbedPandas", new ArrayList<>());
        Logger.exit(this, "getSubbedPandas", null);
        return subbedPandas;
    }
    // Visszaadja a Tile-on allo allatot.
    public Animal getAnimal() {
        Logger.enter(this, "getAnimal", new ArrayList<>());
        Logger.exit(this, "getAnimal", animal);
        return animal;
    }
    // Hozzaad egy szomszedos csempet a szomszedlistahoz
    public void addNeighbor(Tile t) {
        ArrayList<Object> par = new ArrayList<>(); par.add(t);
        Logger.enter(this, "addNeighbor", par);
        neighbors.add(t);
        Logger.exit(this, "addNeighbor", null);
    }
    //Visszadja a feliratkozott pandakat.
    public String writeSubbedPandas(){
        String ret = null;
        for(int i = 0; i < subbedPandas.size(); i++) {
            ret += subbedPandas.get(i).toString() + " ";
        }
        return ret;
    }
    //Visszadja a szomszedokat.
    public String writeNeighbors(){
        String ret = null;
        for(int i = 0; i < neighbors.size(); i++) {
            ret += neighbors.get(i).toString() + " ";
        }
        return ret;
    }
}
