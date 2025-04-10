import Player.*;
public class Board {
    private int movesCount;
    private final PieceType grid[][];
    public Board(){
        grid = new PieceType[3][3];

        initializeBoard();
    }
    private void initializeBoard(){
        movesCount = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j] = PieceType.EMPTY;
            }
        }
    }
    public boolean isFull(){
        return movesCount==9;
    }
    public synchronized void makeMove(int row,int col, PieceType type){
        if(row<0||row>=3||col<0||col>=3||grid[row][col]!=PieceType.EMPTY)
            throw new IllegalArgumentException("Invalid move");
        grid[row][col] = type;
        movesCount++;
    }
    public boolean hasWinner(){
        // Check all rows
        for(int row = 0; row < 3; row++){
            if(grid[row][0]!=PieceType.EMPTY&&grid[row][0]==grid[row][1]&&grid[row][1]==grid[row][2])
                return true;
        }
        // Check all columns
        for(int col = 0; col < 3; col++ ){
            if(grid[0][col]!=PieceType.EMPTY&&grid[0][col]==grid[1][col]&&grid[1][col]==grid[2][col])
                return true;
        }
        // Check diagonals
        if(grid[0][0]!=PieceType.EMPTY && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])
            return true;
        return grid[0][2]!=PieceType.EMPTY && grid[0][2] == grid[1][1] && grid[1][2] == grid[2][0];
    }
    public void printBoard(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col <3; col++){
                System.out.println(grid[row][col]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
