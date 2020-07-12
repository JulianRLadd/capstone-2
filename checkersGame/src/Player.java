import java.util.ArrayList;
import java.util.List;

 public class Player {
    public String color1 = "◎";
    public String color2 = "◍";
    private String king1 = "☢";
    private String king2 = "✪";
    private String vamp2 = "✦";
    private String vamp1 = "✧";

    public String color;
    public String king;
    public String vamp;


    public Player(String side){
        if(side=="red"){
            this.color = color1;
            this.king = king1;
            this.vamp = vamp1;
        }else{
            this.color = color2;
            this.king = king2;
            this.vamp = vamp2;
        }

    }

     public void move(){
         System.out.println("moved the checker");
     }
     public void jump(){
         System.out.println("Jumped the enemy checker");
     }
}
