package lowLevelSystemDesign.basic.snakeAndLadder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Snake {
    private int startPosition;
    private int endPosition;

    public Snake(int startPosition, int endPosition) {
        if(startPosition < endPosition){
            System.out.println("Snake start position "+startPosition+" should be greater then "+endPosition+".");
            return;
        }
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}
