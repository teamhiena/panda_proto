//Kene valami cucc(pl. mainben) ami meghivja majd ennek az osztalynak a megfelelo writeOutput-jat.
public class OutputLanguage {

    //TODO VALAMI TAGVÁLTOZÓ AZ OUTPUTRA

    public void writeTile(Tile t){
        System.out.println("stats of: "+t+"\n"
                +"entity: "+t.getEntity()+"\n"
                +"animal: "+t.getAnimal()+"\n"
                +"subbedPandas: "+t.writeSubbedPandas()+"\n"
                +"neighbors: "+t.writeNeighbors()+"\n");
    }
    public void writeWeakTile(WeakTile t){
        System.out.println("stats of: "+t+"\n"
                +"entity: "+t.getEntity()+"\n"
                +"animal: "+t.getAnimal()+"\n"
                +"subbedPandas: "+t.writeSubbedPandas()+"\n"
                +"neighbors: "+t.writeNeighbors()+"\n"
                +"numOfSteps: "+t.getNumOfSteps()+"\n"
                +"isBroken: "+ Boolean.toString(t.isBroken()));
    }
    public void writeOrangutan(Orangutan o){
        System.out.println("stats of: "+o+"\n"
                +"tile: "+o.getTile()+"\n"
                +"nextTile: "+o.getNextTile()+"\n"
                +"followedBy: "+o.getFollowedBy()+"\n"
                +"following: "+o.getFollowing()+"\n"
                +"score: "+o.getScore());
    }
    public void writePanda(Panda p)
    {
        System.out.println("stats of: "+p+"\n"
                +"tile: "+p.getTile()+"\n"
                +"nextTile: "+p.getNextTile()+"\n"
                +"followedBy: "+p.getFollowedBy()+"\n"
                +"following: "+p.getFollowing());
    }
    public void writeNonEnterableEntity(NonEnterableEntity e){
        System.out.println("stats of: "+e+"\n"
                +"tile: "+e.getTile());
    }
    public void writeFotel(Fotel f){
        System.out.println("stats of: "+f+"\n"
                +"tile: "+f.getTile()+"\n"
                +"enteredFrom: "+f.getEnteredFrom()+"\n"
                +"timeleft: "+f.getTimeLeft());
    }
    public void writeWardrobe(Wardrobe w){
        System.out.println("stats of: "+w+"\n"
                +"tile: "+w.getTile()+"\n"
                +"previousExitTile: "+w.getPreviousExitTile()+"\n"
                +"entrance: "+w.getEntrance());
    }
}


