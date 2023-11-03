public class Levels {
    public static char[][] level1 = new char[][]{
            {'#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#'},
            {'#', 'O', '#', 'O', '#'},
            {'#', '#', '#', '#', '#'}
    };

    public static char[][] level2 = new char[][]{
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', 'O', '#', 'O', '#', 'O', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
    };

    public static char[][] level3 = new char[][]{
            {'#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', 'O', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', 'O', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#'}
    };

    public static char[][] getGrid(int num) {
        return switch (num) {
            case 1 -> level1;
            case 2 -> level2;
            case 3 -> level3;
            default -> throw new IllegalArgumentException("Invalid level number: " + num);
        };
    }
}
