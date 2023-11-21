import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose a level 1,4,6 or 7: ");
        int level = scan.nextInt();
        char[][] grid = Levels.getGrid(level);
        State s = new State(grid, 0);

        System.out.println("Current Grid");
        s.printState();
        System.out.println();

        Logic l = new Logic();
        System.out.println("1 User Player - 2 BFS - 3 DFS - 4 UCS - 5 hill climbing - 6 A*");
        int algo = scan.nextInt();
        switch (algo) {
            case 1 -> l.UserPlayer(s);
            case 2 -> l.BFS(s);
            case 3 -> l.DFS(s);
            case 4 -> l.UCS(s);
            case 5 -> l.hillClimbing(s);
            case 6 -> l.Astar(s);
            default -> throw new IllegalArgumentException("Invalid number: " + algo);
        };

        scan.close();
    }

}