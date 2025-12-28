package snakeladder;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class Board {
    Cell[] cells;

    public Board(int x) {
        this.cells = new Cell[x];
        for(int i = 0; i < x; i++){

                cells[i] = new Cell(i);
                //if(i <= x/2 )cells[i*10 + j].setLadder(new Ladder(new Position(1,0), new Position(i +x/2 , 0)));

        }
    }

    public Cell getCell(int position){
        return cells[position];
    }

    public Boolean isLastCell(int position){
        if(cells.length <= position)return true;
        return false;
    }
}
