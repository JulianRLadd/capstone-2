import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String []args){
        CheckerBoard board = new CheckerBoard();
        board.printBoard();


        // Loop until someone wins
        while (!board.gameOver()) {
            //Try a move and update the board
            try {
                board.getNextMove();
            } catch (IOException e) {
                e.printStackTrace();
            }
            board.printBoard();
        }
        // Game over! Who won???
        System.out.println("The winner is " + board.winnerIs());

    }
}
