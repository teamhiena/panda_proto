/**
 * A szkeleton program (use-case-eket tartalmaz) menujet kezelo osztalyly.
 */
public class Menu {
    public void show(){
        System.out.println("Az alabbi useCase-ekbol valaszthat:\n\n"
                +"1. Orangutan steps on Tile\n"
                +"2. Orangutan steps on WeakTile\n"
                +"3. Orangutan steps on BrokenTile\n"
                +"4. Orangutan cannot enter Tile\n"
                +"5. Orangutan catches its first panda\n"
                +"6. Orangutan catches panda, while it already has panda(s)\n"
                +"7. Orangutan enters wardrobe\n"
                +"8. Orangutan won(FinitTime mode)\n"
                +"9. Orangutan won(FinitPanda mode)\n"
                +"10. Orangutan takes the exit with panda(s)\n"
                +"11. TiredPanda enters fotel\n"
                +"12. AfraidPanda gets frightened\n"
                +"13. DiabeticPanda gets frightened\n"
                +"14. Panda enters wardrobe\n"
                +"15. Panda steps\n"
                +"16. Panda in row steps on BrokenTile\n"
                +"17. Panda in freeroam steps on BrokenTile\n"
                +"---\n"
                +"0. Kilepes\n"
                +"A valasztott UseCase: ");
    }

    public void manageUseCase(int chosenUseCase){
        switch(chosenUseCase) {            //A valasznak megfelelo eset inditasa
            case 0: System.out.println("Kilepes..");
                break;
            case 1: orangutanStepsOnTile();
                break;
            case 2: orangutanStepsOnWeakTile();
                break;
            case 3: orangutanStepsOnBrokenTile();
                break;
            case 4: orangutanCannotEnterTile();
                break;
            case 5: orangutanCatchesItsFirstPanda();
                break;
            case 6: orangutanCatches();
                break;
            case 7: orangutanEntersWardrobe();
                break;
            case 8: orangutanWon_FinitTime();
                break;
            case 9: orangutanWon_FinitPanda();
                break;
            case 10: orangutanTakesTheExit();
                break;
            case 11: tiredPandaEntersFotel();
                break;
            case 12: afraidPandaGetsFrightened();
                break;
            case 13: diabeticPandaGetsFrightened();
                break;
            case 14: pandaEntersWardrobe();
                break;
            case 15: pandaSteps();
                break;
            case 16: pandaInRowStepsOnBrokenTile();
                break;
            case 17: pandaInFreeroamStepsOnBrokenTile();
                break;
            default: System.out.println("Ervenytelen szamot adott meg!");
                break;
        }
    }
    //1.
    public void orangutanStepsOnTile(){
        //Letrehozzuk a szukseges objektumokat.
        Game g = new Game();
        Orangutan o = new Orangutan(g);
        Tile t1 = new Tile(); //Itt van most az orangutan.
        Tile t2 = new Tile(); //Ide akarjuk leptetni.

        //Inicializalas
        o.setTile(t1);
        t1.setAnimal(o);

        //Loggerbe regisztralas
        Logger.enable();;
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(g, "Game", "g");

        //Metodus meghivasa
        o.step(t2);
    }
    //2.
    public void orangutanStepsOnWeakTile(){
        //letrehozzuk a szukseges objektumokat
        Game g = new Game();
        Orangutan o = new Orangutan(g);
        Tile t1 = new Tile();
        WeakTile t2 = new WeakTile();

        //Inicializalas
        t1.setAnimal(o);
        o.setTile(t1);

        //Loggerbe regisztralas
        Logger.enable();;
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "WeakTile", "t2");
        Logger.register(g, "Game", "g");

        //Metodus meghivasa
        o.step(t2);

    }
    //3.
    public void orangutanStepsOnBrokenTile(){
        //Letrehozzuk a szukseges objektumokat
        Game g = new Game();
        Orangutan o = new Orangutan(g);
        Tile t1 = new Tile();
        WeakTile t2 = new WeakTile();

        //Inicializalas
        t1.setAnimal(o);
        o.setTile(t1);
        while(!t2.isBroken())
        	t2.reduceNumOfSteps();
        o.step(t2);

        //Loggerbe regisztralas
        Logger.enable();;
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "WeakTile", "t2");
        Logger.register(g, "Game", "g");

        //Metodus meghivasa
        o.step(t2);
    }
    //4.
    public void orangutanCannotEnterTile(){
        //Letrehozzuk a szukseges objektumokat
        Game g = new Game();
        Orangutan o = new Orangutan(g);
        Arcade a = new Arcade(); 
        Tile t1=new Tile();
        Tile t2 = new Tile();

        //Inicializalas
        t1.setAnimal(o);
        o.setTile(t1);
        t2.setEntity(a);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(o, "Orangutan", "o");
        Logger.register(a, "Entity", "a");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(g, "Game", "g");

        //Metodus meghivasa
        o.step(t2);
    }
    //5.
    public void orangutanCatchesItsFirstPanda(){
        //Letrehozzuk a szukseges objektumokat
    	GameMap gm = GameMap.instance();
    	Game g = new Game();
        Orangutan o = new Orangutan(g);
        AfraidPanda p = new AfraidPanda(gm);
        Tile t1 = new Tile();
        Tile t2 = new Tile();

        //Inicializalas
        t1.setAnimal(o);
        o.setTile(t1);
        t2.setAnimal(p);
        p.setTile(t2);
        
        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(p, "AfraidPanda", "p");
        Logger.register(g, "Game", "g");

        //Metodus meghivasa
        o.step(t2);
    }
    //6.
    public void orangutanCatches(){
        //Letrehozzuk a szukseges objektumokat
        Game g = new Game();
    	Orangutan o=new Orangutan(g);
    	Tile t1=new Tile();
    	Tile t2=new Tile();
    	Tile t3=new Tile();
    	GameMap gm = GameMap.instance();
    	DiabeticPanda p1=new DiabeticPanda(gm);
    	AfraidPanda p2=new AfraidPanda(gm);

    	//Inicializalas
    	t1.setAnimal(o);
    	o.setTile(t1);
    	t2.setAnimal(p1);
    	p1.setTile(t2);
    	t3.setAnimal(p2);
    	p2.setTile(t3);

    	//Loggerbe regisztralas
    	Logger.enable();
        Logger.register(gm, "GameMap", "gm");
    	Logger.register(o, "Orangutan", "o");
    	Logger.register(p1, "DiabeticPanda", "p1");
    	Logger.register(p2, "AfraidPanda", "p2");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(t3, "Tile", "t3");
        Logger.register(g, "Game", "g");

        //Metodus(ok) meghivasa
        o.step(t2);
        o.step(t3);
    }
    //7.
    public void orangutanEntersWardrobe(){
        //Letrehozzuk a szukseges objektumokat
    	GameMap gm = GameMap.instance();
    	Game g = new Game();
        Orangutan o = new Orangutan(g);
        Tile entrance = new Tile();
        Tile t2=new Tile(); //WardrobeTile
        Tile exit=new Tile();
        Wardrobe w=new Wardrobe(entrance,gm);

        //Inicializalas
        entrance.setAnimal(o);
        o.setTile(entrance);
        t2.setEntity(w);
        w.setTile(t2);
        gm.addSpecificTile(exit, GameMap.Key.WardrobeExit);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
    	Logger.register(o, "Orangutan", "o");
        Logger.register(entrance, "Tile", "entrance");
        Logger.register(t2, "Tile", "t2");
        Logger.register(exit, "Tile", "exit");
        Logger.register(w, "Wardrobe", "w");
        Logger.register(entrance, "Tile", "entrance");
        Logger.register(g, "Game", "g");

        //Metodus meghivasa
        o.step(t2);
    }
    //8.
    public void orangutanWon_FinitTime(){
        //Letrehozzuk a szukseges objektumokat
        Game g = new Game();
        GameMap gameMap = GameMap.instance();
        Orangutan o =  new Orangutan(g);
        Timer t = Timer.instance();

        //Inicializalas
        g.setSelectedMode(Game.GameMode.FinitTime);
        t.setGamemap(gameMap);
        t.setGame(g);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(g, "Game", "g");
        Logger.register(gameMap, "GameMap", "gameMap");
        Logger.register(o, "Orangutan", "o");
        Logger.register(t, "Timer", "t");

        //Metodus meghivasa
        t.increaseTime(60);
    }
    //9.
    public void orangutanWon_FinitPanda(){
        //Letrehozzuk a szukseges objektumokat
        Game g = new Game();
        GameMap gamemap = GameMap.instance();
        Orangutan o=new Orangutan(g);

        //Inicializalas
        g.setSelectedMode(Game.GameMode.FinitPanda);
        Timer t = Timer.instance();
        t.setGamemap(gamemap);
        t.setGame(g);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(g, "Game", "g");
        Logger.register(o, "Orangutan", "o");
        Logger.register(gamemap, "GameMap", "gameMap");
        Logger.register(t, "Timer", "t");

        //Metodus meghivasa
        o.increaseScore(25);

    }
     //10.
    public void orangutanTakesTheExit(){
        //Letrehozzuk a szukseges objektumokat
        Game g = new Game();
        GameMap gm = GameMap.instance();
        Timer t = Timer.instance();
        Orangutan o = new Orangutan(g);
        AfraidPanda p1 = new AfraidPanda(gm);
        EntryTile entryTile = new EntryTile();
        ExitTile exitTile = new ExitTile();
        Tile t1 = new Tile();

        //Inicializalas
        g.setSelectedMode(Game.GameMode.FinitTime); // ez persze lehet FinitPanda mod is
        t.setGamemap(gm);
        t.setGame(g);
        //allatok steppable listaba felvetel
        t.addSteppable(p1);
        t.addSteppable(o);

        boolean p1Caught = false;
        while(p1Caught == false)
            p1Caught = p1.getCaughtBy(o);

        //exit csempet megelozo csempe init
        t1.addNeighbor(exitTile);
        exitTile.addNeighbor(t1);

        //a panda csempere helyezése
        p1.setTile(t1);
        t1.setAnimal(p1);

        //az orangutan az exit csempere lep
        exitTile.setAnimal(o);
        o.setTile(exitTile);

        //gamemaphez hozza kell adni az entryt
        gm.setEntry(entryTile);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(g, "Game", "g");
        Logger.register(gm, "GameMap", "gm");
        Logger.register(t, "Timer", "t");
        Logger.register(o, "Orangutan", "o");
        Logger.register(p1, "AfraidPanda", "p1");
        Logger.register(entryTile, "EntryTile", "entryTile");
        Logger.register(exitTile, "ExitTile", "exitTile");
        Logger.register(t1, "Tile", "t1");

        //METODUS(OK) meghivasa
        g.exiting(o); //az orangutan elhagyja a mapot
        p1.step(exitTile);//a koveto panda az exit csempere lep
        t.removeSteppable(p1); //a koveto panda torlese a steppable listabol
        p1 = null; //a koveto panda eltavolitasa
    }
    //11.
    public void tiredPandaEntersFotel(){
    	//Letrehozzuk a szukseges objektumokat
    	GameMap gm=GameMap.instance();
    	TiredPanda ap=new TiredPanda(gm);
    	Tile t1=new Tile();
    	Fotel f=new Fotel();
    	Tile t2=new Tile();
    	TiredPanda bp=new TiredPanda(gm);
    	Tile t3=new Tile();
    	
    	//Inicializalas
    	t1.addNeighbor(t2);
    	t2.addNeighbor(t1);
    	t1.addNeighbor(t3);
    	t3.addNeighbor(t1);
    	t1.setEntity(f);
    	f.setTile(t1);    	
    	t2.setAnimal(ap);
    	ap.setTile(t2);
    	t3.setAnimal(bp);
    	bp.setTile(t3);
    	t1.addSubbedPanda(ap);
    	t1.addSubbedPanda(bp);
    	ap.addSubbedTile(t1);
    	bp.addSubbedTile(t1);
    	
    	//Logger
    	Logger.enable();
    	Logger.register(t1, "Tile", "t1");
    	Logger.register(t2, "Tile", "t2");
    	Logger.register(t3, "Tile", "t3");
    	Logger.register(f, "Fotel", "f");
    	Logger.register(ap, "TiredPanda", "ap");
    	Logger.register(bp, "TiredPanda", "bp");
    	Logger.register(gm, "GameMap", "gm");
    	
    	//Metodus meghivasa
    	f.makeEffect();    	
    }
    //12.
    public void afraidPandaGetsFrightened(){
		//Letrehozzuk a szukseges objektumokat
    	GameMap gm=GameMap.instance();
    	AfraidPanda ap=new AfraidPanda(gm);
    	Tile t1=new Tile();
    	Arcade a=new Arcade();
    	Tile t2=new Tile();
    	
    	//Inicializalas
    	t1.addNeighbor(t2);
    	t2.addNeighbor(t1);    	
    	t1.setEntity(a);
    	a.setTile(t1);    	
    	t2.setAnimal(ap);
    	ap.setTile(t2);
    	t1.addSubbedPanda(ap);
    	ap.addSubbedTile(t1);
    	
    	//Logger
    	Logger.enable();
    	Logger.register(t1, "Tile", "t1");
    	Logger.register(t2, "Tile", "t2");
    	Logger.register(a, "Arcade", "a");
    	Logger.register(ap, "AfraidPanda", "ap");
    	Logger.register(gm, "GameMap", "gm");
    	
    	//Metodus meghivasa
    	a.makeEffect();    	
    }
    //13.
    public void diabeticPandaGetsFrightened(){
    	//Letrehozzuk a szukseges objektumokat
    	GameMap gm=GameMap.instance();
    	DiabeticPanda dp=new DiabeticPanda(gm);
    	Tile t1=new Tile();
    	Automat a=new Automat();
    	Tile t2=new Tile();
    	
    	//Inicializalas
    	t1.addNeighbor(t2);
    	t2.addNeighbor(t1);    	
    	t1.setEntity(a);
    	a.setTile(t1);    	
    	t2.setAnimal(dp);
    	dp.setTile(t2);
    	t1.addSubbedPanda(dp);
    	dp.addSubbedTile(t1);
    	
    	//Loggerbe rergisztralas
    	Logger.enable();
    	Logger.register(t1, "Tile", "t1");
    	Logger.register(t2, "Tile", "t2");
    	Logger.register(a, "Automat", "a");
    	Logger.register(dp, "AfraidPanda", "ap");
    	Logger.register(gm, "GameMap", "gm");
    	
    	//Metodus meghivasa
    	a.makeEffect();    	
    }
    //14.
    public void pandaEntersWardrobe(){
        //Letrehozzuk a szukseges objektumokat
    	GameMap gm = GameMap.instance();
        DiabeticPanda p = new DiabeticPanda(gm);
        Tile entrance = new Tile();
        Tile t2=new Tile(); //WardrobeTile
        Tile exit = new Tile();
        Tile exit2 = new Tile();

        //Inicializalas
        entrance.setAnimal(p);
        p.setTile(entrance);
        Wardrobe w=new Wardrobe(entrance,gm);
        t2.setEntity(w);
        w.setTile(t2);
        gm.addSpecificTile(exit, GameMap.Key.WardrobeExit);
        gm.addSpecificTile(exit2, GameMap.Key.WardrobeExit);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
    	Logger.register(p, "Panda", "p");
        Logger.register(t2, "Tile", "t2");
        Logger.register(exit, "Tile", "exit");
        Logger.register(exit2, "Tile", "exit2");
        Logger.register(w, "Wardrobe", "w");
        Logger.register(entrance, "Tile", "entrance");

        //Metodus meghivasa
        p.step(t2);
    }
    //15.
    public void pandaSteps(){
        //Letrehozzuk a szukseges objektumokat
        GameMap gm = GameMap.instance();
        AfraidPanda p = new AfraidPanda(gm);
        Tile oldt = new Tile(); //Itt all most
        Tile newt = new Tile(); //Ide lep
        Tile nt = new Tile();
        Tile newnt = new Tile();

        //Inicializalas
        p.setTile(oldt);
        oldt.getNeighbors().add(nt);
        newt.getNeighbors().add(newnt);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
        Logger.register(p, "AfraidPanda", "p");
        Logger.register(oldt, "Tile", "oldt");
        Logger.register(newt, "Tile", "newt");
        Logger.register(nt, "Tile", "nt");
        Logger.register(newnt, "Tile", "newnt");

        //Metodus meghivasa
        p.step(newt);

    }
    //16.
    public void pandaInRowStepsOnBrokenTile(){
        System.out.println("Ezt sajna nem volt idonk megcsinalni!:(");
    }
    //17.
    public void pandaInFreeroamStepsOnBrokenTile(){
        //Letrehozzuk a szukeseges objektumokat
        GameMap gm = GameMap.instance();
        AfraidPanda p = new AfraidPanda(gm);
        Tile t1 = new Tile();
        WeakTile t2 = new WeakTile();

        //Inicializalas
        /*for(int i = 30; i >= 0; i--)
            t2.reduceNumOfSteps();*/        

        while(!t2.isBroken())
        	t2.reduceNumOfSteps();
        
        t1.setAnimal(p);
        p.setTile(t1);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
        Logger.register(p, "AfraidPanda", "p");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "WeakTile", "t2");

        //Metodus meghivasa
        p.step(t2);
    }
}
