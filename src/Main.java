import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose a level 1,4,6 or 7: ");
        int level = scan.nextInt();
        char[][] grid = Levels.getGrid(level);
        State s = new State(grid);

        System.out.println("Current Grid");
        s.printState();
        System.out.println();

        Logic l = new Logic();
        System.out.println("1 User Player - 2 BFS - 3 DFS - 4 UCS");
        int algo = scan.nextInt();
        switch (algo) {
            case 1 -> l.UserPlayer(s);
            case 2 -> l.BFS(s);
            case 3 -> l.DFS(s);
            case 4 -> l.UCS(s);
            default -> throw new IllegalArgumentException("Invalid number: " + algo);
        };

        scan.close();
    }

}