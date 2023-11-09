import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class State {
    char[][] grid;
    int rows, columns;

    public State(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        State otherState = (State) obj;
        return Arrays.deepEquals(this.grid, otherState.grid);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(this.grid);
    }

    public Set<Entry<Integer, Integer>> checkMoves() {
        Set<Entry<Integer, Integer>> positions = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 'O') {
                    Entry<Integer, Integer> position = new SimpleEntry<>(i, j);
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

            State newState = this.move(i,j);
            states.add(newState);
        }
        return states;
    }

    public State move(int row, int column) {
        char[][] newGrid = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(grid[i], 0, newGrid[i], 0, columns);
        }

        if (newGrid[row][column] == 'O') {
            newGrid[row][column] = ' ';
            // Check and update the adjacent cells in the new state
            // Left
            if (newGrid[row][column - 1] == 'O') {
                newGrid[row][column - 1] = ' ';
            } else if (newGrid[row][column - 1] == ' ') {
                newGrid[row][column - 1] = 'O';
            }
            // Right
            if (newGrid[row][column + 1] == 'O') {
                newGrid[row][column + 1] = ' ';
            } else if (newGrid[row][column + 1] == ' ') {
                newGrid[row][column + 1] = 'O';
            }
            // Top
            if (newGrid[row - 1][column] == 'O') {
                newGrid[row - 1][column] = ' ';
            } else if (newGrid[row - 1][column] == ' ') {
                newGrid[row - 1][column] = 'O';
            }
            // Bottom
            if (newGrid[row + 1][column] == 'O') {
                newGrid[row + 1][column] = ' ';
            } else if (newGrid[row + 1][column] == ' ') {
                newGrid[row + 1][column] = 'O';
            }
        } else {
            System.out.println("No action.");
        }

        // Create and return a new State with the updated grid
        return new State(newGrid);
    }

    public boolean isFinal(){
        boolean win = true;
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == 'O') {
                    win = false;
                    break;
                }
            }
        }
        return win;
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
