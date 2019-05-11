import java.util.ArrayList;

public class Orangutan extends Animal {
    private int score = 0;
    private int stepCounter = 4;
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
        //ha elkap valakit akkor nem kell lepni a tobbi pandanak
        Tile temp=tile;
        boolean success = t.receiveAnimal(this);

        if(success){
            stepCounter++;
            if(isFollowedBy()){
                followedBy.step(temp);
            }
        }
        return success;
    }

    /**
     * A megadott mertekben noveli a jatekos(orangutan) pontszamat.
     */
    public void increaseScore(int p) {
        score += p;
        //Minden novelesnel megnezzuk, hogy elertuk-e a gyozelem szukseges pandaszamot.
        if(score >= 25 && game.getSelectedMode() == Game.GameMode.FinitPanda){
            //Ha elertuk, szolunk a jateknak hogy vege.
            game.SaveHighScore(score);
            game.gameOver();
        }
    }

    public int getPandaNum() {
        Panda a = this.followedBy;
        int num = 1;
        if (a != null) {
            while (a.followedBy != null) {
                num++;
                a = a.followedBy;
            }
            return num;
        }
        else return 0;
    }

    /**
     * A bejarathoz helyezi az orangutant.
     */
    public void goToEntry() {
        this.step(GameMap.instance().getEntryTile());
    }

    /**
     * A score adattag getter fuggvenye.
     */
    public int getScore() { return score; }

    /**
     * A parameterben megadott orangutan elkapja az orangutant.
     */
    @Override
    public boolean getCaughtBy(Orangutan o)
    {
        if(o.getFollowedBy() != null || followedBy == null) return false; //Ha az elkaponak vannak pandai vagy nekunk nincsenek pandaink --> nem tortenik semmi

        //Az orangutanok helyet cserelnek.
        Tile temp = tile; //Az aktualis orangutan Tile-ja megy a temp-be.
        tile = o.getTile();
        o.setTile(temp);
        o.getTile().setAnimal(o);
        tile.setAnimal(this);

        //Atadjuk a pandakat.
        o.setFollowedBy(followedBy);
        followedBy.setFollowing(o);
        o.getFollowedBy().setNextTile(o.getTile());
        followedBy = null;

        //Nullaznunk kell a lepesszamlalot.
        stepCounter = 0;

        return false; //Ha eddig eljutottunk, mindenkeppen sikeres a belepes.
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
        if(followedBy!=null)
        {
            followedBy.release();
            followedBy = null;
        }
    }

    public int getStepCounter(){return stepCounter;}
    public void increaseCounter(){stepCounter++;}
}
