import java.util.List;
public class GamePlay {
    final private Board board;
    final private List<Player>playerList;
    final private List<Snake>snakeList;
    final private List<Ladder>ladderList;
    final private Dice dice;
    private int currentPlayerIndex;
    public GamePlay(Board board,List<Snake>snakeList,List<Player>playerList,List<Ladder>ladderList,Dice dice){
        this.board = board;
        this.playerList = playerList;
        this.ladderList = ladderList;
        this.snakeList = snakeList;
        this.dice = dice;
        currentPlayerIndex = 0;  // Basically player turns
    }
    public void play(){
        while(!isGameOver()){
            Player currentPlayer = playerList.get(currentPlayerIndex);
            int currentPlayerPosition = currentPlayer.getCurrentPosition();
            int diceRoll = dice.roll();
            int newPosition = currentPlayerPosition+diceRoll;
            if(newPosition<=board.getBoardSize()){
                currentPlayer.setCurrentPosition(newPosition);
                System.out.println("Player :"+currentPlayer.getName()+" has rolled a dice to:"+diceRoll+" and moved to new position :"+currentPlayer.getCurrentPosition());
            }
            if(currentPlayer.getCurrentPosition()==board.getBoardSize()){
                System.out.println("Player :"+currentPlayer.getName()+" wins the game");
                break;
            }
            currentPlayerIndex = (currentPlayerIndex+1)%playerList.size();
        }
    }
    private boolean isGameOver(){
        for(Player player:playerList){
            if(player.getCurrentPosition()==board.getBoardSize())
                return  true;
        }
        return false;
    }
}
