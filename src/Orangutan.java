import java.util.ArrayList;

public class Orangutan extends Animal {
    private int score = 0;
    private Game game;

    public Orangutan(Game g) {
        g.addOrangutan(this);
        game = g;
    }

    //METODUSOK
    /**
     * @param t(Tile): Errre a mezore szeretnenk leptetni az orangutant.
     * @return Megadja, hogy sikerult-e a muvelet.
     */
    @Override
    public boolean step(Tile t) {
        ArrayList<Object> par = new ArrayList<>(); par.add(t);
        Logger.enter(this, "step", par);
        //ha elkap valakit akkor nem kell l�pni a tobbi pandanak

        boolean success=t.receiveAnimal(this);
        if(success)
        {
        	if(followedBy!=null)
        		followedBy.setNextTile(tile);
        }
        Logger.exit(this, "step", success);
        return success;
    }

    /**
     * A megadott mertekben noveli a jatekos(orangutan) pontszamat.
     */
    public void increaseScore(int p) {
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "increaseScore", par);
        score += p;

        //Minden novelesnel megnezzuk, hogy elertuk-e a gyozelem szukseges pandaszamot.
        if(score >= 25 && game.getSelectedMode() == Game.GameMode.FinitPanda){
            //Ha elertuk, szolunk a jateknak hogy vege.
            game.SaveHighScore(score);
            game.gameOver();
        }
        Logger.exit(this, "increaseScore", null);
    }

    public int getPandaNum() {
        Logger.enter(this, "getPandaNum", new ArrayList<>());
        //return mindfuck recursive fuggveny(?) nem hinnem hogy szukseg van most ra (M)
        //TODO
        int ret = 0;
        Logger.exit(this, "getPandaNum", ret);

        return ret;
    }

    /**
     * A bejarathoz helyezi az orangutant.
     */
    public void goToEntry() {
        Logger.enter(this, "goToEntry", new ArrayList<>());
        this.step(GameMap.instance().getEntryTile());
        Logger.exit(this, "goToEntry", null);
    }

    /**
     * A score adattag getter fuggvenye.
     */
    public int getScore() {
        Logger.enter(this, "getScore", new ArrayList<>());
        int ret = score;
        Logger.exit(this, "getScore", ret);
        return ret;
    }

    /**
     * Ertelemszeruen, egy orangutan nem kaphat el egy masik orangutant.
     */
    @Override
    public boolean getCaughtBy(Orangutan o) {
        ArrayList<Object> par = new ArrayList<>(); par.add(o);
        Logger.enter(this, "getCaughtBy", par);
        Logger.exit(this, "getCaughtBy", false);
        return false;
    }

    /**
     * A game adattag setter fuggvenye.
     */
    public void setGame(Game game) {
        this.game = game;
    }
    /**
     * Elengedi az ot koveto pandak kezet.
     */
    public void releasePandas()
    {
        if(/*isFollowing == true*/ following!=null)
        {
            following.release();
            following = null;
            //isFollowing = false;
        }
    }
}
