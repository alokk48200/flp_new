package snakeladder;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
       // Player player1 =new Player("alok")
        Game game = Game.getInstance(20,4, Arrays.asList(new Player("alok",1), new Player("rahul",1)));
        game.startGame();


    }
}
