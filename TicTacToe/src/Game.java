import Player.*;
import java.util.Scanner;
public class Game {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;
    public Game(Player player1,Player player2){
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        this.board = new Board();
    }
    public void play(){
        board.printBoard();
        while(!board.isFull()&&!board.hasWinner()){
            System.out.println(currentPlayer.getPlayerName()+ "s'Turn");
            int row =  getValidInput("Enter row (0-2): ");
            int col = getValidInput("Enter col (0-2): ");
            try{
                board.makeMove(row,col,currentPlayer.getType());
                board.printBoard();
                switchPlayer();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        if(board.hasWinner()){
            switchPlayer();
            System.out.println(currentPlayer.getPlayerName()+" is the winner");
        }else{
            System.out.println("Its a draw match");
        }
    }

    private void switchPlayer(){
        currentPlayer=(currentPlayer==player1?player2:player1);
    }
    private int getValidInput(String message){
        Scanner sc = new Scanner(System.in);
        int input;
        while(true){
            System.out.println(message);
            if(sc.hasNextInt()){
                input = sc.nextInt();
                if(input>=0&&input<=2)
                    return input;
            }else{
                sc.next();
            }
            System.out.println("Invalid input! Please enter a number between 0 and 2.");
        }
    }


}
