package systemDesign.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean playerTurn = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome please enter size of board!!");
        int boardSize = scanner.nextInt();
        Player player1 = new Player("Hariom","hariom@gmail.com",'X');
        Player player2 = new Player("Vishna","vishna@gmail.com",'Y');
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        Board board = new Board(boardSize,playerList);
        int totalMoves =boardSize*boardSize;
        for(int i=1; i<=totalMoves; i++){
            board.displayBoard();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Player currentPlayer = board.playerQueue.poll();
            if(!board.move(x,y,currentPlayer)) break;
            board.playerQueue.add(currentPlayer);
        }
    }
}
