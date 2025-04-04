package Player;

public class Player {
    String playerName;
    PieceType type;
    public Player(String playerName,PieceType type){
        this.playerName = playerName;
        this.type = type;
    }
    public String getPlayerName(){
        return playerName;
    }
    public PieceType getType(){
        return type;
    }
}
