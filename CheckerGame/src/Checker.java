
public class Checker implements IChecker{
    public String color;
    public Player owner;
    public boolean status;
    public int x;
    public int y;


    public Checker(Player player, String color, int x, int y){
        this.color = color;
        this.owner = player;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return this.color;
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
    public void move(){
        System.out.println("moved the checker");
    }
    public void jump(){
        System.out.println("Jumped the enemy checker");
    }
    public void kingMe(){
        System.out.println("Kinged the checker");
    }

    public static Checker createChecker(Player player,String color,int x, int y){
        return new Checker(player,color,x,y);
    }

}