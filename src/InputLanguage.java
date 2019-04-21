import java.util.ArrayList;
import java.util.HashMap;

public class InputLanguage {

    private HashMap<String,Object> variables=new HashMap<String,Object>();
    //TODO exceptionök: nem letezika  command,  nem letezik a valtozo/letezik mar amikor letre akarom hozni

    public void addVariable(String key, Object object){
        if(getVariable(key)!=null) {
            System.out.println("A variable with the same name already exists");
        }
        else
            variables.put(key, object);
    }

    public Object getVariable(String key){
        Object ret=null;
        try{
            ret=variables.get(key);
        }
        catch(Exception e){
            System.out.println("Variable does not exist");
            return null;
        }
        return  ret;

    }

    class Node{

        private String description="";
        //Type type;
        private HashMap<String,Node> next=new HashMap<String,Node>();

        public Node(String d/*,Type t*/){
            description=d;
            //type=t;

        }
        public Node() {};

        public void addNext(Node n) {
            next.put(n.description,n);
        }

        public Object search(String key) {
            //System.out.println("executing "+this.description+" returning: "+next.get(key).description+" key: "+key);
            Object ret;
            try{
                ret=next.get(key);
            }catch (Exception e){
                System.out.println("Unknown keyword: '"+key+"'");
                return null;
            }
            return next.get(key);
        }

        public Object execute(Object p){return null;}
    }

    class Leaf extends Node{
        public Object execute(Object o_param){return null;}
        public Leaf(String p){
            super(p);
        }
    }

    Node root=new Node("root");

    public InputLanguage(){
        init();
    }
    public Node init() {
        OutputLanguage outputLanguage = new OutputLanguage();
        Node tmp;
        Node newNode;
        //INIT ROOT
        tmp=new Node("new");
        root.addNext(tmp);
        root.addNext(new Node("step"));
        root.addNext(new Node("set"));
        root.addNext(new Node("stat"));
        root.addNext(new Node("release"));
        root.addNext(new Node("makeeffect"));
        root.addNext(new Node("output"));
        root.addNext(new Node("test"));

            //INIT NEW
            newNode = new Node("tile");
            tmp.addNext(newNode);
            tmp.addNext(new Leaf("orangutan") {
            public Object execute(Object o_param) {
                String[] parameters=(String[]) o_param;
                Orangutan o=new Orangutan();
                o.setTile((Tile)getVariable(parameters[4])); //ELÉG RISKY SOR
                System.out.println("CREATING ORANGUTAN ; name="+parameters[3]);
                variables.put(parameters[3],o);
                return o;
            }
            });
            tmp.addNext(new Node("panda"));
            tmp.addNext(new Node("entity"));
            tmp=newNode;

                //INIT NEW/TILE
                newNode=new Leaf("weak"){
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        WeakTile t=new WeakTile();
                        System.out.println("CREATING WEAK TILE ; name="+parameters[3]);
                        variables.put(parameters[3],t);
                        return t;
                    }
                };
                tmp.addNext(newNode);
                tmp.addNext(new Leaf("empty") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        Tile t=new Tile();
                        System.out.println("CREATING TILE ; name="+parameters[3]);
                        variables.put(parameters[3],t);
                        return t;
                    }
                });
                tmp.addNext(new Leaf("entry") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        EntryTile t=new EntryTile();
                        System.out.println("CREATING ENTRY TILE ; name="+parameters[3]);
                        variables.put(parameters[3],t);
                        return t;
                    }
                });
                tmp.addNext(new Leaf("exit") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        ExitTile t=new ExitTile();
                        System.out.println("CREATING EXIT TILE ; name="+parameters[3]);
                        variables.put(parameters[3],t);
                        return t;
                    }
                });

                //INIT NEW/ENTITY
                tmp=root.next.get("new").next.get("entity");
                tmp.addNext(new Leaf("wardrobe") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        Wardrobe w=new Wardrobe();
                        w.setTile((Tile)getVariable(parameters[4])); //ELÉG RISKY SOR
                        w.setEntrance((Tile)getVariable(parameters[5]));
                        System.out.println("CREATING WARDROBE ENTITY ; name="+parameters[3]);
                        variables.put(parameters[3],w);
                        return w;
                    }
                });
                tmp.addNext(new Leaf("arcade") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        Arcade a=new Arcade();
                        a.setTile((Tile)getVariable(parameters[4])); //ELÉG RISKY SOR
                        System.out.println("CREATING ARCADE ENTITY ; name="+parameters[3]);
                        variables.put(parameters[3],a);
                        return a;
                    }
                });
                tmp.addNext(new Leaf("automat") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        Automat a=new Automat();
                        a.setTile((Tile)getVariable(parameters[4])); //ELÉG RISKY SOR
                        System.out.println("CREATING AUTOMAT ENTITY ; name="+parameters[3]);
                        variables.put(parameters[3],a);
                        return a;
                    }
                });

                tmp.addNext(new Leaf("fotel") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        Fotel f=new Fotel();
                        f.setTile((Tile)getVariable(parameters[4])); //ELÉG RISKY SOR
                        System.out.println("CREATING ARCADE ENTITY ; name="+parameters[3]);
                        variables.put(parameters[3],f);
                        return f;
                    }
                });

                //INIT NEW/PANDA
                tmp=root.next.get("new").next.get("panda");
                tmp.addNext(new Leaf("diabetic") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        DiabeticPanda p=new DiabeticPanda();
                        p.setTile((Tile)getVariable(parameters[4])); //ELÉG RISKY SOR
                        System.out.println("CREATING DIABETIC PANDA ; name="+parameters[3]);
                        variables.put(parameters[3],p);
                        return p;
                    }
                });
                tmp.addNext(new Leaf("tired") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        TiredPanda p=new TiredPanda();
                        p.setTile((Tile)getVariable(parameters[4]));
                        System.out.println("CREATING TIRED PANDA ; name="+parameters[3]);
                        variables.put(parameters[3],p);
                        return p;
                    }
                });
                tmp.addNext(new Leaf("afraid") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        AfraidPanda p=new AfraidPanda();
                        p.setTile((Tile)getVariable(parameters[4]));
                        System.out.println("CREATING AFRAID PANDA ; name="+parameters[3]);
                        variables.put(parameters[3],p);
                        return p;
                    }
                });

            //INIT STEP
            tmp=root.next.get("step");
            tmp.addNext(new Leaf("panda") {
                public Object execute(Object o_param) {
                    String[] parameters=(String[]) o_param;
                    Panda p=(Panda)getVariable(parameters[2]);
                    Tile t=(Tile)getVariable(parameters[3]);
                    System.out.println("STEPPING "+parameters[2]+" to "+parameters[3]);
                    p.step(t);
                    return p;
                }
            });
            tmp.addNext(new Leaf("orangutan") {
                public Object execute(Object o_param) {
                    String[] parameters=(String[]) o_param;
                    Orangutan o=(Orangutan)getVariable(parameters[2]);
                    Tile t=(Tile)getVariable(parameters[3]);
                    System.out.println("STEPPING "+parameters[2]+" to "+parameters[3]);
                    o.step(t);
                    return o;
                }
            });

            //INIT SET
            tmp=root.next.get("set");
            tmp.addNext(new Leaf("neighbor") {
                public Object execute(Object o_param) {
                    String[] parameters=(String[]) o_param;
                    Tile t=(Tile)getVariable(parameters[2]);
                    Tile nt;
                    System.out.println("SETTING NEIGHBORS OF : "+parameters[2]);
                    for (int i=1;i<parameters.length;i++){
                        nt=(Tile)getVariable(parameters[i]);
                        t.addNeighbor(nt);
                        nt.addNeighbor(t);
                    }
                    return t;
                }
            });
            tmp.addNext(new Leaf("numOfSteps") {
                public Object execute(Object o_param) {
                    String[] parameters=(String[]) o_param;
                    WeakTile t=(WeakTile)getVariable(parameters[2]);
                    t.setNumOfSteps(Integer.parseInt(parameters[3]));
                    System.out.println("SETTING NUMOFSTEPS OF : "+parameters[2]+" to : "+parameters[3]);
                    return t;
                }
            });

            tmp.addNext(new Leaf("fotelTimeLeft") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    String[] parameters=(String[]) o_param;
                    Fotel f=(Fotel)getVariable(parameters[2]);
                    f.setTimeLeft(Integer.parseInt(parameters[3]));
                    System.out.println("SETTING TIMELEFT OF : "+parameters[2]+" to : "+parameters[3]);
                    return f;
                }
            });

            //INIT RELEASE
            tmp=root.next.get("set");
            tmp.addNext(new Leaf("orangutan") {
                public Object execute(Object o_param) {
                    String[] parameters=(String[]) o_param;
                    Orangutan o=(Orangutan)getVariable(parameters[2]);
                    o.releasePandas();
                    System.out.println("RELEASING PANDAS OF "+parameters[2]);
                    return o;
                }
            });

            //-----------------------MEGUNTAM-------------------

            //INIT MAKEEFFECT
            tmp=root.next.get("makeeffect");
            tmp.addNext(new Leaf("arcade") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO arcade.makeEffect();
                    return null;
                }
            });
            tmp.addNext(new Leaf("automat") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO automat.makeEffect();
                    return null;
                }
            });

            tmp.addNext(new Leaf("fotel") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO fotel.makeEffect();
                    return null;
                }
            });

            //INIT OUTPUT
            tmp=root.next.get("output");
            tmp.addNext(new Leaf("console") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO output a console
                    return null;
                }
            });
            tmp.addNext(new Leaf("file") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO output egy fajl, el van picit rejtve egy uj node;
                    return null;
                }
            });

            //INIT TEST
            tmp=root.next.get("test");
            tmp.addNext(new Leaf("all") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO mindet teszteljuk
                    return null;
                }
            });
            tmp.addNext(new Leaf("number") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO egy adott tesztet futtatunk, el van picit rejtve egy uj node;
                    return null;
                }
            });

            //INIT STAT
            tmp=root.next.get("stat");
            tmp.addNext(new Leaf("panda") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO miklos fuggvenyei
                    outputLanguage.writePanda((Panda) o_param);
                    return null;
                }
            });
            tmp.addNext(new Leaf("orangutan") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO miklos fuggvenyei
                    outputLanguage.writeOrangutan((Orangutan)o_param);
                    return null;
                }
            });
            tmp.addNext(new Node("entity") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO miklos fuggvenyei
                    //Ez miert kell?
                    return null;
                }
            });
                //INIT STAT/ENTITY
                newNode=new Leaf("arcade") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
                        outputLanguage.writeNonEnterableEntity((Arcade)o_param);
                        return null;
                    }
                };
                tmp.addNext(newNode);
                tmp.addNext(new Leaf("automat") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
                        outputLanguage.writeNonEnterableEntity((Automat)o_param);
                        return null;
                    }
                });
                tmp.addNext(new Leaf("fotel") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
                        outputLanguage.writeFotel((Fotel)o_param);
                        return null;
                    }
                });
                tmp.addNext(new Leaf("wardrobe") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
                        outputLanguage.writeWardrobe((Wardrobe)o_param);
                        return null;
                    }
                });

                //INIT STAT/TILE
                tmp=root.next.get("stat");
                newNode=new Node("tile");
                tmp.addNext(newNode);
                newNode.addNext(new Leaf("strong") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
                        outputLanguage.writeTile((Tile)o_param);
                        return null;
                    }
                });
                newNode.addNext(new Leaf("weak") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
                        outputLanguage.writeTile((WeakTile)o_param);
                        return null;
                    }
                });
        return root;
    }

    public Object compile(String[] param) {
        //System.out.println("compiling...");
        int i=0;
        //ELMEGYUNK A LEAFHEZ
        Node n=root.next.get(param[i]);
        while (n!=null&&n.next.size()!=0){
            n=(Node)(n.search(param[++i]));
        }
        //LEAFET TALALTUNK
        Object ret=n.execute(param);
        return ret;
    }

}
