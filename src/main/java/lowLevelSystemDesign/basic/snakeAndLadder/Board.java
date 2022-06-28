package lowLevelSystemDesign.basic.snakeAndLadder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Board {
    private int boardSize;
    private Queue<Player> playerQueue;
    private HashMap<Integer,Integer> snakeMap;
    private HashMap<Integer,Integer> ladderMap;
    private HashMap<Player,Integer> playerAndCurrentPosition;

    public Board(int boardSize, List<Snake> snakes, List<Ladder> ladders,List<Player> players) {
        this.boardSize = boardSize;
        playerQueue = new LinkedList<>();
        playerAndCurrentPosition = new HashMap<>();
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();
        for(int i=0; i<players.size(); i++){
            playerQueue.add(players.get(i));
            playerAndCurrentPosition.put(players.get(i),0);
        }
        for(Snake snake : snakes){
            snakeMap.put(snake.getStartPosition(),snake.getEndPosition());
        }
        for(Ladder ladder : ladders) {
            ladderMap.put(ladder.getStartPosition(), ladder.getEndPosition());
        }
    }

    public void startGame(){
        System.out.println("Game Started!!");
        Dice dice = new Dice(1);
        while(true){
            Player currentPlayer = playerQueue.poll();
            System.out.println(currentPlayer.getName()+" Turn and current position "+playerAndCurrentPosition.get(currentPlayer));
            int diceValue = dice.rollingDice();
            System.out.println("Dice rolled "+diceValue);
            int newPosition = playerAndCurrentPosition.get(currentPlayer) + diceValue;
            if(ladderMap.containsKey(newPosition)){
                System.out.println(currentPlayer.getName()+" Takes Ladder from "+ newPosition + " to "+ladderMap.get(newPosition));
                newPosition = ladderMap.get(newPosition);
            }
            if(snakeMap.containsKey(newPosition)){
                System.out.println(currentPlayer.getName()+" beaten by snake from "+ newPosition + " to "+snakeMap.get(newPosition));
                newPosition = snakeMap.get(newPosition);
            }
            if(newPosition == boardSize){
                System.out.println(currentPlayer.getName()+" Won the Game");
                break;
            }
            if(newPosition <= boardSize)
                playerAndCurrentPosition.put(currentPlayer,newPosition);
            playerQueue.add(currentPlayer);
        }
    }
}
