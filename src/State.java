import java.util.HashSet;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

public class State {
    char[][] grid;
    int rows, columns;

    public State(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;
    }

    public boolean equal(State s2){
        if(rows == s2.grid.length && columns == s2.grid[0].length){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] != s2.grid[i][j])  return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    public Set<Entry<Integer, Integer>> checkMoves() {
        Set<Entry<Integer, Integer>> positions = new HashSet<>();
        int rows = grid.length, columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 'O') {
                    Entry<Integer, Integer> position = new SimpleEntry<>(i+1, j+1);
                    positions.add(position);
                }
            }
        }
        return positions;
    }

    public List<State> getNextState(){
        List<State> states = new ArrayList<>();
        Set<Entry<Integer, Integer>> positions = this.checkMoves();

        for (Entry<Integer, Integer> position : positions) {
            int i = position.getKey();
            int j = position.getValue();

            System.out.println(i + "," + j);
            State newState = this.move(i-1,j-1);
            newState.printState();
            states.add(newState);
        }
        System.out.println();
        return states;
    }

    public State move(int row, int column) {
        char[][] newGrid = new char[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, newGrid[i], 0, grid[i].length);
        }

        if (newGrid[row][column] == 'O') {
            newGrid[row][column] = ' ';
            // Check and update the adjacent cells in the new state
            // Left
            if (column > 0 && newGrid[row][column - 1] == 'O') {
                newGrid[row][column - 1] = ' ';
            } else if (column > 0 && newGrid[row][column - 1] == ' ') {
                newGrid[row][column - 1] = 'O';
            }
            // Right
            if (column < newGrid[0].length - 1 && newGrid[row][column + 1] == 'O') {
                newGrid[row][column + 1] = ' ';
            } else if (column < newGrid[0].length - 1 && newGrid[row][column + 1] == ' ') {
                newGrid[row][column + 1] = 'O';
            }
            // Top
            if (row > 0 && newGrid[row - 1][column] == 'O') {
                newGrid[row - 1][column] = ' ';
            } else if (row > 0 && newGrid[row - 1][column] == ' ') {
                newGrid[row - 1][column] = 'O';
            }
            // Bottom
            if (row < newGrid.length - 1 && newGrid[row + 1][column] == 'O') {
                newGrid[row + 1][column] = ' ';
            } else if (row < newGrid.length - 1 && newGrid[row + 1][column] == ' ') {
                newGrid[row + 1][column] = 'O';
            }
        } else {
            System.out.println("No action.");
        }

        // Create and return a new State with the updated grid
        return new State(newGrid);
    }

    public boolean isFinal(){
        int Os = 0;
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == 'O')    Os ++;
            }
        }
        return Os == 0;
    }
    public void printState() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

}
