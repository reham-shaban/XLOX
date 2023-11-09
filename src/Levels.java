public class Levels {

    public static char[][] level1 = new char[][]{
            {'#', '#', '#', '#'},
            {'#', ' ', 'O', '#'},
            {'#', 'O', ' ', '#'},
            {'#', '#', '#', '#'}
    };
    public static char[][] level4 = new char[][]{
            {'#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#'},
            {'#', 'O', '#', 'O', '#'},
            {'#', '#', '#', '#', '#'}
    };

    public static char[][] level6 = new char[][]{
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', 'O', '#', 'O', '#', 'O', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
    };

    public static char[][] level7 = new char[][]{
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
            case 4 -> level4;
            case 6 -> level6;
            case 7 -> level7;
            default -> throw new IllegalArgumentException("Invalid level number: " + num);
        };
    }
}
