import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Player>playerList = new ArrayList<>();
        Player player1 = new Player("Varun");
        Player player2 = new Player("Monica");
        playerList.add(player1);
        playerList.add(player2);
        List<Snake>snakeList = List.of(new Snake(2,10),new Snake(45,69),new Snake(14,55));
        List<Ladder>ladderList = List.of(new Ladder(7,24),new Ladder(30,50),new Ladder(64,98));
        Board board = new Board(100,snakeList,ladderList);
        GamePlay gamePlay = new GamePlay(board,snakeList,playerList,ladderList,new Dice(1,6));
        gamePlay.play();
    }
}