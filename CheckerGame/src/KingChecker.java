//public class KingChecker extends Checker{
//
//    private boolean color;
//    private boolean owner;
//    private boolean status;
//
//
//    //☢✪✦✧
//    protected KingChecker(boolean owner, boolean color, char x, char y){
//        super(owner,color,x,y);
//        this.status = true;
//    }
//
//    public void move(){
//        System.out.println("moved the king checker");
//    }
//    public void jump(){
//        System.out.println("Jumped the enemy checker");
//    }
////    public void vampMe(){
////        System.out.println("Vamped the checker");
////    }
//
//    public static Checker createKingChecker(Player owner,boolean color,char x, char y){
//        Checker newKingChecker = new KingChecker(owner,color,x,y);
//        return newKingChecker;
//    }
//
//}