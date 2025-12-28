package snakeladder;

public class Cell {
    private Integer position;
    private Snake snake;
    private Ladder ladder;



    public Cell(Integer position) {
        this.position = position;
        this.snake = null;
        this.ladder = null;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public  boolean canMove( Integer position){
        if(ladder == null && snake ==  null)return true;
        return false;
    }
    // builder class can be  used here
    public static class cellBuilder{
        private Integer position;
        private Snake snake;
        private Ladder ladder;

        private cellBuilder setPosition(int position){
            this.position = position;
            return this;
        }

    }
}
