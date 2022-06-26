package systemDesign.snakeAndLadder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Ladder {
    private int startPosition;
    private int endPosition;

    public Ladder(int startPosition, int endPosition) {
        if(startPosition > endPosition){
            System.out.println("Ladder start position "+startPosition+" should be less then "+endPosition+".");
            return;
        }
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}
