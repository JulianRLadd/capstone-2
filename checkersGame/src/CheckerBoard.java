import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.*;

public class CheckerBoard {
    private int size = 8;
    public String [][]board;
    public Player player1;

    public Player player2;
    public List<Checker> allCheckers;
    public boolean player1Turn;

    public CheckerBoard(){
        player1Turn = true;
        allCheckers = new ArrayList<Checker>();
        player1 = new Player("red");
        player2 = new Player("black");
        board = new String [size][size];
        for(int i=0;i<size;i++){
            if(i%2==1){
                for(int j=0;j<size;j++) {

                    if(j%2==1){
                        board[i][j] = "☐";
                    }else{
                        board[i][j] = "◼";
                    }
                }
            } else{
                for(int j=0;j<size;j++){
                    if (j % 2 == 1) {
                        board[i][j] = "◼";
                    }else{
                        board[i][j] = "☐";
                    }
                }
            }
        }
        for (int i=1;i<size;i+=2) {
            board[i][1] = "◎";
            Checker newChecker = Checker.createChecker(player1,player1.color,i,1);
            allCheckers.add(newChecker);
            board[i][5] = "◍";
            allCheckers.add(Checker.createChecker(player2,player2.color,i,5));
            board[i][7] = "◍";
            allCheckers.add(Checker.createChecker(player2,player2.color,i,7));
        }
        for (int i=0;i<size;i+=2) {
            board[i][0] = "◎";
            allCheckers.add(Checker.createChecker(player1,player1.color,i,0));
            board[i][2] = "◎";
            allCheckers.add(Checker.createChecker(player1,player1.color,i,2));
            board[i][6] = "◍";
            allCheckers.add(Checker.createChecker(player2,player2.color,i,6));
        }
    }

    public void printBoard(){
            int i,j;
            System.out.println("  ➊ ➋ ➌ ➍ ➎ ➏ ➐ ➑  x");
            for (i=0;i<size;i++) {
                System.out.print((i+1) + " ");
                for (j=0;j<size;j++) {
                    System.out.print(board[j][i]+ " ");
                }
                System.out.println();
            }
            System.out.println("y");
        }

    public void getNextMove() throws IOException {

        Scanner stdin = new Scanner(System.in);

        if (player1Turn)
            System.out.println("Red! It's your turn.");
        else
            System.out.println("Come on up Black! Your turn.");

        boolean moved = false;

        while (!moved) {
            try{
            // Reads in square to move from and to.
            System.out.println("Enter from the square you would like to move from.");
            System.out.print("Enter as a 2-digit number. (e.g. if you were moving from");
            System.out.println(" x=1,y=3, enter 13");
                int movefrom = stdin.nextInt();


            System.out.print("Enter from the square you would like to move to, ");
            System.out.println("using the same convention.");
            int moveto = stdin.nextInt();

            // Checks if the move is acceptable
            if (validMove(movefrom,moveto)) {
                executeMove(movefrom,moveto);
                moved = true;
            }
            else
                System.out.println("That was an invalid move, try again.");
                printBoard();
            }
            catch(InputMismatchException ex){
                System.out.println("Error. Must input a numeral.");
                    printBoard();
                    getNextMove();
            }
        }

        // Switches whose turn it is
        if (player1Turn == true)
            player1Turn = false;
        else
            player1Turn = true;
    }



    public boolean validMove(int movefrom, int moveto) {
        Player turn = player1Turn==true? player1:player2;

        // Fancy way to get the coordinates
        int xfrom = movefrom/10 - 1;
        int yfrom = movefrom%10 - 1;
        int xto = moveto/10 - 1;
        int yto = moveto%10 - 1;

        // Make sure parameters are in bound
        if (xfrom < 0 || xfrom > 7 || yfrom < 0 || yfrom > 7 ||
                xto < 0 || xto > 7 || yto < 0 || yto > 7)
            return false;


        else if (board[xfrom][yfrom]==turn.color && board[xto][yto]=="☐") {

            // Move check
            if (Math.abs(xfrom-xto)==1) {
                if ((player1Turn == true) && (yto - yfrom == 1))
                    return true;
                else if ((player1Turn == false) && (yto - yfrom == -1))
                    return true;
            }


            // Jump check
            else if (Math.abs(xfrom-xto)==2) {
                if (player1Turn == true && (yto - yfrom == 2) &&
                        board[(xfrom+xto)/2][(yfrom+yto)/2] == "◍")
                    return true;
                else if (player1Turn == false && (yto - yfrom == -2) &&
                        board[(xfrom+xto)/2][(yfrom+yto)/2] == "◎")
                    return true;
            }
        }

        return false;
    }

    public void executeMove(int movefrom, int moveto) {
        Player turn = player1Turn==true? player1:player2;

        int xfrom = movefrom/10 - 1;
        int yfrom = movefrom%10 - 1;
        int xto = moveto/10 - 1;
        int yto = moveto%10 - 1;

        // If jump, updates the board properly
        board[xfrom][yfrom] = "☐";
        board[xto][yto] = turn.color;
        if (Math.abs(xto - xfrom) == 2) {
            board[(xfrom+xto)/2][(yfrom+yto)/2] = "☐";

            Optional<Checker> jumped = removeChecker.remove((xfrom+xto)/2,(yfrom+yto)/2);
            allCheckers.remove(jumped);
        }

    }

    public boolean gameOver() {
        return (!findAmount.anyLeft(player1) || !findAmount.anyLeft(player2));
    }

    public String winnerIs() {
        if (findAmount.anyLeft(player2))
            return "red";
        else
            return "black";
    }

    LambdaCheck  findAmount = (Player owner) -> {
        Boolean num = allCheckers.stream()
                .anyMatch(x->x.getOwner().equals(owner));
        return num;
    };

    LambdaDelete  removeChecker = (int jumpedX, int jumpedY) -> {
        Optional<Checker> jumped = allCheckers.stream()
                .filter(x->x.getX()==(jumpedX))
                .filter(x->x.getY()==(jumpedY))
                .findFirst();
        return jumped;
    };


}
interface LambdaCheck{
    public boolean anyLeft(Player owner);
}
interface LambdaDelete{
    public Optional<Checker> remove(int x,int y);
}