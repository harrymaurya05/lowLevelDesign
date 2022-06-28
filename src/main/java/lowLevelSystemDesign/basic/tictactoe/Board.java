package lowLevelSystemDesign.basic.tictactoe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Board {
    public char[][] board;
    private int SIZE = 3;
    public int vertical[] ;
    public int horizontal[];
    public int diagonal;
    public int antiDiagonal;
    public Queue<Player> playerQueue;
    public Board(int boardSize, List<Player> playerList){
        this.SIZE = boardSize;
        board = new char[SIZE][SIZE];
        vertical = new int[SIZE];
        horizontal = new int[SIZE];
        diagonal = 0;
        antiDiagonal = 0;
        playerQueue = new LinkedList<>();
        playerQueue.add(playerList.get(0));
        playerQueue.add(playerList.get(1));
        for(int x=0;x<board.length;x++)
            Arrays.fill(board[x],'O');
    }
    public boolean move(int x, int y, Player player){
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("Invalid Move!!");
            return false;
        }
        if(player.getSymbol() == 'X'){
            board[x][y] = player.getSymbol();
            horizontal[x]++;
            vertical[y]++;
            if(x==y){
                diagonal++;
            }else if(SIZE - x == y || SIZE - y == x){
                antiDiagonal++;
            }

        } else {
            board[x][y] = player.getSymbol();
            horizontal[x]--;
            vertical[y]--;
            if(x==y){
                diagonal--;
            }else if(SIZE - x == y || SIZE - y == x){
                antiDiagonal--;
            }
        }
        return isCurrentPlayerWins(x,y,player);
    }

    private boolean isCurrentPlayerWins(int x,int y, Player player) {
        if(player.getSymbol() == 'X' &&  (vertical[y] == SIZE || horizontal[x] == SIZE || diagonal == SIZE || antiDiagonal == SIZE)){
            System.out.println(player.getName()+" Won the Game.");
            return false;
        } else if(player.getSymbol() == 'Y' &&  (vertical[y] == -1*SIZE || horizontal[x] == -1*SIZE || diagonal == -1*SIZE || antiDiagonal == -1*SIZE)){
            System.out.println(player.getName()+" Won the Game.");
            return false;
        }
        return true;
    }
    public void displayBoard(){
        System.out.println("Current Board !!");
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}
