import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A szkeletonhoz tartozó segedosztaly, ennek segitsegevel egyszerubben tudjuk kezelni a hivasi lancot.
 */
public class Logger {
    private static Map<Object, Object_information> map = new HashMap<Object, Object_information>();
    private static int depth = 0;
    private static boolean enabled = false;

    public static void register(Object o, String type, String name){
        map.put(o, new Object_information(type, name));
    }

    public static void enter(Object o, String funcName, List<Object> parameters){
        /**
         * Ha a logolas nincsen engedelyezve, nem csinalunk semmit.
         */
        if(!enabled) return;

        /**
         * Eltolas
         */
        String tab = "";
        for(int i=0; i<depth; i++){
            tab += "  ";
        }
        depth++; //Ertelemszeruen novelnunk kell a melyseget amikor valaki belep.

        /**
         * Parameterlista megvalositasa.
         */
        String param = "";
        for(Object i : parameters) {
            param += ", "; //elvalasztashoz

            if (i == null)
                param += "null";
            else if (map.containsKey(i))
                param += "[" + map.get(i).getType() + "]" + map.get(i).getName();
            else
                param += i.toString();
        }
        if(param.length()>2) param = param.substring(2); //Van az elejen egy felesleges vesszo + egy space

        /**
         * Kiiras
         */
        System.out.println(tab+"-> "+ "[" + map.get(o).getType() + "]" + map.get(o).getName() + "." + funcName +"(" + param +")");

    }
    public static void exit(Object o, String funcName, Object returnValue){
        if(!enabled) return;

        depth--; //Ha valaki belep, csokkentenunk kell a melyseget.
        String tab="";
        for (int i=0; i<depth; i++){
            tab+="  ";
        }

        /**
         * Visszateresi ertekbol String
         */
        String retVal = "";
        if(returnValue != null){
            if(map.containsKey(returnValue))
                retVal = "["+map.get(returnValue).getType()+"]"+map.get(returnValue).getName();
            else
                retVal = returnValue.toString();
        }

        /**
         * Kiiras
         */
        System.out.println(tab+"<- "+"["+map.get(o).getType()+"]"+map.get(o).getName()+"."+funcName+"("+")"+(retVal.equals("") ? "" : ("  [" + retVal + "]")));

    }

    public static void enable() {enabled = true;}
    public static void disable() {enabled = false;}
}
