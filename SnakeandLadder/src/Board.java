import java.util.HashMap;
import java.util.List;
public class Board {
    private final int boardSize;
    private final HashMap<Integer,Integer>snakes;
    private final HashMap<Integer,Integer>ladders;
    public Board(int boardSize,List<Snake>snakeList,List<Ladder>ladderList){
        this.boardSize = boardSize;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        for(Snake snake:snakeList){
            snakes.put(snake.getHead(),snake.getTail());
        }
        for(Ladder ladder:ladderList){
            ladders.put(ladder.getStart(),ladder.getEnd());
        }
    }
    public int getBoardSize(){
        return boardSize;
    }
    public int getNextPosition(int position){
        if(snakes.containsKey(position))
            return snakes.get(position);
        if(ladders.containsKey(position))
            return ladders.get(position);
        return position;
    }
}
