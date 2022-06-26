import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import systemDesign.snakeAndLadder.Board;
import systemDesign.snakeAndLadder.Ladder;
import systemDesign.snakeAndLadder.Player;
import systemDesign.snakeAndLadder.Snake;

public class TestSnakeAndLadderGame {
    @Test
    public void testGame(){
        int boardSize = 100;
        List<Ladder> ladders = new ArrayList<>();
        List<Snake> snakes = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Hariom",1));
        players.add(new Player("Vishna",2));
        snakes.add(new Snake(16,6));
        snakes.add(new Snake(49,11));
        snakes.add(new Snake(47,26));
        snakes.add(new Snake(62,2));
        snakes.add(new Snake(87,12));
        ladders.add(new Ladder(1,36));
        ladders.add(new Ladder(4,14));
        ladders.add(new Ladder(9,31));
        //ladders.add(new Ladder(28,84));
        //ladders.add(new Ladder(80,boardSize));
        Board board = new Board(boardSize,snakes,ladders,players);
        board.startGame();
    }
}
