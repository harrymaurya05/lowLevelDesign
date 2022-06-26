package systemDesign.snakeAndLadder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Dice {
    private int numberOfDices;

    public Dice(int numberOfDices) {
        this.numberOfDices = numberOfDices;
    }
    public int rollingDice(){
        return ((int)(Math.random()*(6*numberOfDices - 1*numberOfDices))) + 1;
    }
}
