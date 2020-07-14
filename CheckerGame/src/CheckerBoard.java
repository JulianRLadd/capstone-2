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
                    board[i][j] = j%2==1?"☐":"◼";
                }
            } else{
                for(int j=0;j<size;j++){
                    board[i][j] = j%2==1?"◼":"☐";
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

    public void nextMove() throws IOException {

        Scanner stdin = new Scanner(System.in);

        if (player1Turn)
            System.out.println("Red! It's your turn.");
        else
            System.out.println("Come on up Black! Your turn.");

        boolean moved = false;

        while (!moved) {
            try{
                // Reads the chosen checker and its destination.
                System.out.println("Enter the coordinates of the checker you want to move.");
                System.out.print("For example, entering 37 (x=3,y=7) would move the most right and front red checker");
                int moveFrom = stdin.nextInt();


                System.out.print("Please enter the coordinates you would like the selected checker to move to: ");
                int moveTo = stdin.nextInt();

                // Checks if the move is acceptable
                if (validMove(moveFrom,moveTo)) {
                    executeMove(moveFrom,moveTo);
                    moved = true;
                }
                else
                    System.out.println("Invalid move. Please try again.");
                    printBoard();
            }
            catch(InputMismatchException ex){
                System.out.println("Error. Must input a numeral.");
                printBoard();
                nextMove();
            }
        }

        // Switches whose turn it is
        if (player1Turn == true)
            player1Turn = false;
        else
            player1Turn = true;
    }



    public boolean validMove(int moveFrom, int moveTo) {
        Player turn = player1Turn==true? player1:player2;

        // Fancy way to get the coordinates
        int xFrom = moveFrom/10 - 1;
        int yFrom = moveFrom%10 - 1;
        int xTo = moveTo/10 - 1;
        int yTo = moveTo%10 - 1;

        // Make sure parameters are in bound
        if (xFrom < 0 || xFrom > 7 || yFrom < 0 || yFrom > 7 ||
                xTo < 0 || xTo > 7 || yTo < 0 || yTo > 7)
            return false;


        else if (board[xFrom][yFrom]==turn.color && board[xTo][yTo]=="☐") {

            // Move check
            if (Math.abs(xFrom-xTo)==1) {
                if ((player1Turn == true) && (yTo - yFrom == 1))
                    return true;
                else if ((player1Turn == false) && (yTo - yFrom == -1))
                    return true;
            }

            //make y coordinates absolute for king and vamp checkers!!

            // Jump check
            else if (Math.abs(xFrom-xTo)==2) {
                if (player1Turn == true && (yTo - yFrom == 2) &&
                        (board[(xFrom+xTo)/2][(yFrom+yTo)/2] == "◍"||board[(xFrom+xTo)/2][(yFrom+yTo)/2] == "✦"))
                    return true;
                else if (player1Turn == false && (yTo - yFrom == -2) &&
                        (board[(xFrom+xTo)/2][(yFrom+yTo)/2] == "◎"||board[(xFrom+xTo)/2][(yFrom+yTo)/2] == "✧"))
                    return true;
             }
        }

        return false;
    }

    public void executeMove(int moveFrom, int moveTo) {
        Player turn = player1Turn==true? player1:player2;

        int xFrom = moveFrom/10 - 1;
        int yFrom = moveFrom%10 - 1;
        int xTo = moveTo/10 - 1;
        int yTo = moveTo%10 - 1;

        //Updates checker and board
        Checker movedChecker = selectedChecker.shift(xFrom,yFrom).get();
        movedChecker.setX(xTo);
        movedChecker.setY(yTo);
        String newLocation = board[xFrom][yFrom];
        board[xTo][yTo] = newLocation;
        board[xFrom][yFrom] = "☐";


        // If jump, updates the board properly
        if (Math.abs(xTo - xFrom) == 2) {
            board[(xFrom+xTo)/2][(yFrom+yTo)/2] = "☐";
            Checker jumped = selectedChecker.shift((xFrom+xTo)/2,(yFrom+yTo)/2).get();
            allCheckers.remove(jumped);
        }
    }

    public boolean gameOver() {
        return (!findAmount.anyLeft(player1) || !findAmount.anyLeft(player2));
    }

    public String winner() {
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


    LambdaFind  selectedChecker = (int jumpedX, int jumpedY) -> {
        Optional<Checker> jumped = allCheckers.stream()
                .filter(x->x.getX()==(jumpedX))
                .filter(x->x.getY()==(jumpedY))
                .findAny();

        return jumped;
    };

}
interface LambdaCheck{
    public boolean anyLeft(Player owner);
}
interface LambdaFind{
    public Optional<Checker> shift(int x,int y);
}