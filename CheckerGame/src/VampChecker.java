public class VampChecker extends KingChecker{

        private String color;
        private Player owner;
        private int x;
        private int y;

        protected VampChecker(Player owner, String color, int x, int y){
            super(owner,color,x,y);
        }

        public static VampChecker createVampChecker(Player owner, String color, int x, int y){
            return new VampChecker(owner,color,x,y);
        }


}
