package snakeladder;

import java.util.Random;

public class Dice {
    private static Random random = new Random();
    public static int roll(){
        return 1+random.nextInt(6);
    }
}
