public class Structure {
    char[][] grid;

    public Structure(int level) {
        if (level == 1) {
            grid = new char[][]{
                    {'#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', '#'},
                    {'#', ' ', '#', ' ', '#'},
                    {'#', 'O', '#', 'O', '#'},
                    {'#', '#', '#', '#', '#'}
            };
        } else if (level == 2) {
            grid = new char[][]{
                    {'#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                    {'#', 'O', '#', 'O', '#', 'O', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                    {'#', '#', '#', '#', '#', '#', '#'}
            };
        } else if (level == 3) {
            grid = new char[][]{
                    {'#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', '#'},
                    {'#', '#', '#', 'O', '#'},
                    {'#', ' ', ' ', ' ', '#'},
                    {'#', 'O', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', '#'},
                    {'#', '#', '#', '#', '#'}
            };
        } else {
            System.out.println("Invalid grid number. Choose 1, 2, or 3.");
        }
    }

    public void move(int row, int column){
        if(grid[row][column] == 'O'){
            grid[row][column] = ' ';
            // Check and update the adjacent cells
            // Left
            if (column > 0 && grid[row][column - 1] == 'O') {
                grid[row][column - 1] = ' ';
            }
            else if (column > 0 && grid[row][column - 1] == ' ') {
                grid[row][column - 1] = 'O';
            }
            // Right
            if (column < grid[0].length - 1 && grid[row][column + 1] == 'O') {
                grid[row][column + 1] = ' ';
            }
            else if (column < grid[0].length - 1 && grid[row][column + 1] == ' ') {
                grid[row][column + 1] = 'O';
            }
            // Top
            if (row > 0 && grid[row - 1][column] == 'O') {
                grid[row - 1][column] = ' ';
            }
            else if (row > 0 && grid[row - 1][column] == ' ') {
                grid[row - 1][column] = 'O';
            }
            // Bottom
            if (row < grid.length - 1 && grid[row + 1][column] == 'O') {
                grid[row + 1][column] = ' ';
            }
            else if (row < grid.length - 1 && grid[row + 1][column] == ' ') {
                grid[row + 1][column] = 'O';
            }
        }
        else{
            System.out.println("No action.");
        }
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
    public void printGrid() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

}
