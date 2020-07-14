public class KingChecker extends Checker{

    private String color;
    private Player owner;
    private int x;
    private int y;

    protected KingChecker(Player owner, String color, int x, int y){
        super(owner,color,x,y);
    }


//    public void vampMe(){
//        System.out.println("Vamped the checker");
//    }

    public static KingChecker createKingChecker(Player owner,String color, int x, int y){
        KingChecker newKingChecker = new KingChecker(owner,color,x,y);
        return newKingChecker;
    }

}