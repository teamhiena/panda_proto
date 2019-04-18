import java.util.ArrayList;
import java.util.HashMap;

public class InputLanguage {

    private HashMap<String,Object> objects=new HashMap<String,Object>();
    //TODO exceptionök: em letezika  command, nem letezik a valtozo/letezik mar
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
            newNode=new Node("tile");
            tmp.addNext(newNode);
            tmp.addNext(new Leaf("orangutan") {
            public Object execute(Object o_param) {
                String descr=(String) o_param;
                return new Orangutan();
            }
            });
            tmp.addNext(new Node("panda"));
            tmp.addNext(new Node("entity"));
            tmp=newNode;

                //INIT NEW/TILE
                newNode=new Leaf("weak"){
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        return new WeakTile();
                    }
                };
                tmp.addNext(newNode);
                tmp.addNext(new Leaf("empty") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        return new Tile();
                    }
                });
                tmp.addNext(new Leaf("entry") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        return new EntryTile();
                    }
                });
                tmp.addNext(new Leaf("exit") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        return new ExitTile();
                    }
                });

                //INIT NEW/ENTITY
                tmp=root.next.get("new").next.get("entity");
                tmp.addNext(new Leaf("wardrobe") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        return new Wardrobe();
                    }
                });
                tmp.addNext(new Leaf("arcade") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        return new Arcade();
                    }
                });
                tmp.addNext(new Leaf("automat") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        return new Automat();
                    }
                });

                tmp.addNext(new Leaf("fotel") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        return new Fotel();
                    }
                });

                //INIT NEW/PANDA
                tmp=root.next.get("new").next.get("panda");
                tmp.addNext(new Leaf("diabetic") {
                    public Object execute(Object o_param) {
                        String[] parameters=(String[]) o_param;
                        DiabeticPanda p=new DiabeticPanda();
                        System.out.println("CREATING DIABETIC PANDA ; name="+parameters[3]);
                        variables.put(parameters[3],p);
                        return p;
                    }
                });
                tmp.addNext(new Leaf("tired") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        return new TiredPanda();
                    }
                });
                tmp.addNext(new Leaf("afraid") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        return new AfraidPanda();
                    }
                });

            //INIT STEP
            tmp=root.next.get("step");
            tmp.addNext(new Leaf("panda") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO panda.Step();
                    return null;
                }
            });
            tmp.addNext(new Leaf("orangutan") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO oranguan.Step();
                    return null;
                }
            });

            //INIT SET
            tmp=root.next.get("set");
            tmp.addNext(new Leaf("neighbor") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO oranguan.Step();
                    return null;
                }
            });
            tmp.addNext(new Leaf("numOfSteps") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO tile.valamidecreselos();
                    return null;
                }
            });

            tmp.addNext(new Leaf("fotelTimeLeft") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO vmi foteldescreaselos();
                    return null;
                }
            });

            //INIT RELEASE
            tmp=root.next.get("set");
            tmp.addNext(new Leaf("orangutan") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO orangutan.release();
                    return null;
                }
            });

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
                    //TODO egy adott tezstet futtatunk, el van picit rejtve egy uj node;
                    return null;
                }
            });

            //INIT STAT
            tmp=root.next.get("stat");
            tmp.addNext(new Leaf("panda") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO miklos fuggvenyei
                    return null;
                }
            });
            tmp.addNext(new Leaf("orangutan") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO miklos fuggvenyei
                    return null;
                }
            });
            tmp.addNext(new Node("entity") {
                public Object execute(Object o_param) {
                    String descr=(String) o_param;
                    //TODO miklos fuggvenyei
                    return null;
                }
            });
                //INIT STAT/ENTITY
                newNode=new Leaf("arcade") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
                        return null;
                    }
                };
                tmp.addNext(newNode);
                tmp.addNext(new Leaf("automat") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
                        return null;
                    }
                });
                tmp.addNext(new Leaf("wardrobe") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
                        return null;
                    }
                });
                tmp.addNext(new Leaf("wardrobe") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
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
                        return null;
                    }
                });
                newNode.addNext(new Leaf("weak") {
                    public Object execute(Object o_param) {
                        String descr=(String) o_param;
                        //TODO miklos fuggvenyei
                        return null;
                    }
                });
        return root;
    }

    public Object compile(String[] param) {
        System.out.println("compiling...");
        int i=0;
        Node n=root.next.get(param[i]);
        //a new panda execute-ja szar, null-lal tér vissza
        while (n.next.size()!=0){
            n=(Node)(n.search(param[++i]));
        } //LEAFET TALALTUNK
        Object ret=n.execute(param);
        return ret;
    }

    HashMap<String,Object> variables=new HashMap<String,Object>();
}
