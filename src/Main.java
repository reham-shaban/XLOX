import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose a level 1,2 or 3: ");
        int level = scan.nextInt();
        char[][] grid = Levels.getGrid(level);

        State s = new State(grid);
        Logic l = new Logic();
        l.UserPlayer(s);

        scan.close();
    }

}