public class KingChecker extends Checker{

    private String color;
    private Player owner;
    private int x;
    private int y;

    protected KingChecker(Player owner, String color, int x, int y){
        super(owner,color,x,y);
    }

    public static KingChecker createKingChecker(Player owner,String color, int x, int y){
        return new KingChecker(owner,color,x,y);
    }

}