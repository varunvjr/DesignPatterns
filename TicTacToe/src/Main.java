import Player.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe Game");
        Player player1 = new Player("Varun",PieceType.X);
        Player player2 = new Player("Monica",PieceType.O);
        Game game = new Game(player1,player2);
        game.play();
    }
}