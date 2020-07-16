import java.util.ArrayList;
import java.util.List;

public class Player extends Owner {
    private String color;
    private String king;
    private String vamp;

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

    public String getColor() {
        return this.color;
    }

    public String getKing() {
        return this.king;
    }

    public String getVamp() {
        return this.vamp;
    }

}