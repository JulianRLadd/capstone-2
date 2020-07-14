import java.util.ArrayList;
import java.util.List;

public class Player extends Owner {
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


}