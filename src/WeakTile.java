import java.util.ArrayList;

public class WeakTile extends Tile{
	private int numOfSteps=20;
	private boolean isBroken=false;

	//METODUSOK
	public void reduceNumOfSteps() {
		Logger.enter(this, "reduceNumOfSteps", new ArrayList<>());
		numOfSteps--;
		if(numOfSteps<=0)
			isBroken=true;
		Logger.exit(this, "reduceNumOfSteps", null);
	}
	
	/**
	 * ha broken, die()-t hiv
	 * ha entity, stepIn()-t hiv
	 * ha allat, getCaught()-t hiv
	 */
	@Override
    public boolean receiveAnimal(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "receiveAnimal", par);

    	if(isBroken()) {
    		o.die();
    		Logger.exit(this, "receiveAnimal", false);
    		return false;    		
    	}
    	reduceNumOfSteps();
    	boolean success=false;
    	if(entity!=null)//ha van ott entiy akk megprobalok belelepni
    		success=entity.stepIn(o); //ha nem enterable vagy panda ul benne akk false
    	else if(animal!=null) {
    		success=animal.getCaughtBy(o);
    	}

		Logger.exit(this, "receiveAnimal", success);
    	return false;
    }

	/**
	 * Az isBroken adattag getter fuggvenye.
	 */
	public boolean isBroken() {
		Logger.enter(this, "isBroken", new ArrayList<>());
		Logger.exit(this, "isBroken", isBroken);
    	return isBroken;
    }
	/**
	 * ha broken, die()-t hiv
	 * ha allat, return false
	 * ha entity, stepIn()-t hiv
	 */
	@Override
    public boolean receiveAnimal(Panda p) {
		ArrayList<Object> par = new ArrayList<>(); par.add(p);
		Logger.enter(this, "receiveAnimal", par);

    	if(isBroken()) {
    		p.die();
    		Logger.exit(this, "receiveAnimal", false);
    		return false;
    	}
    	reduceNumOfSteps();
		boolean success=false;

		if(!isBroken){
			if(animal!=null) //ha van ott allat akk fix off
			{
				Logger.exit(this, "receiveAnimal", false);
				return false;
			}
			else if (entity!=null) { //ha van ott entity akkor attol fugg
				if (entity.stepIn(p)) { //bele lehet lepni
					animal=p;
				}
				else{
					Logger.exit(this, "receiveAnimal", true);
					return false;
				}
			}

			//Ilyenkor mar mindenkeppen be tudtunk lepni a csempere.
			this.reduceNumOfSteps();
			Logger.exit(this, "receiveAnimal", true);
			return true;
		}
		else if(entity!=null) { //ha van ott entity akkor attol fugg
    		success=entity.stepIn(p);		
    	}
        else{
            p.die();

            Logger.exit(this, "receiveAnimal", false);
            return false;
        }
    	Logger.exit(this, "receiveAnimal", success);
		return success;

    }
    public int getNumOfSteps(){ return numOfSteps; }
}
