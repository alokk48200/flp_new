package snakeladder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Game {
    private static Game game;
    private Board board;
    private Deque<Player> players ;
    private Dice dice;
    public Boolean isGameStart;

    private Game(int x, int y, List<Player>players) {
         this.board = new Board(x);
         this.players = new ArrayDeque<>(players);
         this.isGameStart = false;

    }
    public static synchronized Game getInstance(int x, int y, List<Player>players){
        if(game == null) {
            synchronized (Game.class) {
                if (game == null) {
                    game = new Game(x,y,players);
                }
            }
        }
        return game;
    }
    public void OnBoard(List<Player> players1){
        if(this.isGameStart == true){
            System.out.println("this player can not be added beacuse they are in ");
            return;
        }
        this.isGameStart = true;
        for(Player player : players1){
            System.out.println("this player is onBoarded " +player.getName());
            this.players.add(player);
        }
    }

    public void startGame(){
        if(isGameStart == true){
            System.out.println("this game is already started");
            return;
        }
        while (true){
            if(players.size() <=  1){
                System.out.println(" game is over");
                return;
            }
            Player player =getNextPlayer();
            int rollValue = Dice.roll();
            int playerPoition = player.getPosition();
             Cell playerCell = board.getCell(playerPoition);
            System.out.println("this player "+player.getName() + " is go this number on roll "+ rollValue);
             if(playerCell.canMove(rollValue)){
                 playerPoition = playerPoition +rollValue;
                 player.setPosition(playerPoition);
                 System.out.println("player successfully moved to new position " + playerPoition);


             }
             if(!board.isLastCell(playerPoition)){
                players.addLast(player);
             }else {
                 System.out.println("this player has wind the game");
             }

        }
    }
    private Player getNextPlayer(){
        Player player = players.getFirst();
        players.removeFirst();
        return player;
    }



}
