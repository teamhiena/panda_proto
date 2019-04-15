/**
 * A Loggerben talalhato Map hasznalatahoz szukseges segedosztaly.
 */
public class Object_information {
    String type;
    String name;

    Object_information(String type, String name){
        this.type = type;
        this.name = name;
    }
    public String getType(){
        return type;
    }
    public String getName() {
        return name;
    }
}
