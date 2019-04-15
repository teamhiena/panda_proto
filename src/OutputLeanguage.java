//Kene valami cucc(pl. mainben) ami meghivja majd ennek az osztalynak a megfelelo writeOutput-jat.
public class OutputLeanguage {
    public void writeTile(Tile t){
        System.out.println("stats of: "+t.toString()+"\n"
                +"entity: "+t.getEntity().toString()+"\n"
                +"animal: "+t.getAnimal().toString()+"\n"
                +"subbedPandas: "+t.writeSubbedPandas()+"\n"
                +"neighbors: "+t.writeNeighbors()+"\n");
    }
    public void writeTile(WeakTile t){
        System.out.println("stats of: "+t.toString()+"\n"
                +"entity: "+t.getEntity().toString()+"\n"
                +"animal: "+t.getAnimal().toString()+"\n"
                +"subbedPandas: "+t.writeSubbedPandas()+"\n"
                +"neighbors: "+t.writeNeighbors()+"\n"
                +"numOfSteps: "+t.getNumOfSteps()+"\n"
                +"isBroken: "+ Boolean.toString(t.isBroken()));
    }
    public void writeOrangutan(Orangutan o){
        System.out.println("stats of: "+o.toString()+"\n"
                +"tile: "+o.getTile().toString()+"\n"
                +"nextTile: "+o.getNextTile().toString()+"\n"
                +"followedBy: "+o.getFollowedBy()+"\n"
                +"following: "+o.getFollowing()+"\n"
                +"score: "+o.getScore());
    }
    public void writeNonEnterableEntity(NonEnterableEntity e){
        System.out.println("stats of: "+e.toString()+"\n"
                +"tile: "+e.getTile().toString());
    }
    public void writeFotel(Fotel f){
        System.out.println("stats of: "+f.toString()+"\n"
                +"tile: "+f.getTile().toString()+"\n"
                +"enteredFrom: "+f.getEnteredFrom().toString()+"\n"
                +"timeleft: "+f.getTimeLeft());
    }
    public void writeWardrobe(Wardrobe w){
        System.out.println("stats of: "+w.toString()+"\n"
                +"tile: "+w.getTile().toString()+"\n"
                +"previousExitTile: "+w.getPreviousExitTile().toString()+"\n"
                +"entrance: "+w.getEntrance());
    }
}


