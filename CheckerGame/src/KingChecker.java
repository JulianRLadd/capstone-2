public class KingChecker extends Checker{

    private String color;
    private Player owner;
    private int x;
    private int y;

    //☢✪✦✧
    protected KingChecker(Player owner, String color, int x, int y){
        super(owner,color,x,y);
    }

    public void move(){
        System.out.println("moved the king checker");
    }
    public void jump(){
        System.out.println("Jumped the enemy checker");
    }

//    public void vampMe(){
//        System.out.println("Vamped the checker");
//    }

    public static Checker createKingChecker(Player owner,String color, int x, int y){
        Checker newKingChecker = new KingChecker(owner,color,x,y);
        return newKingChecker;
    }

}