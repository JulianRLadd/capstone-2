
public class Checker implements IChecker{
    private String color;
    private Player owner;
    private int x;
    private int y;


    public Checker(Player player, String color, int x, int y){
        this.color = color;
        this.owner = player;
        this.x = x;
        this.y = y;
    }

    public Player getOwner() {
        return this.owner;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }


    public void setX(int newX) {
        this.x = newX;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public void info(){
        System.out.println("Color:"+this.color);
        System.out.println("Owner:"+this.owner);
        System.out.println("X:"+this.x);
        System.out.println("Y:"+this.y);

    }

    public KingChecker kingMe(int x, int y){
        KingChecker king = KingChecker.createKingChecker(this.owner,this.owner.getKing(),x,y);
        return king;
    }

    public VampChecker vampMe(int x, int y){
        VampChecker vamp = VampChecker.createVampChecker(this.owner,this.owner.getVamp(),x,y);
        return vamp;
    }

    public static Checker createChecker(Player player,String color,int x, int y){
        return new Checker(player,color,x,y);
    }

}