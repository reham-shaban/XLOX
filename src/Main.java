import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Choose a level 1,2 or 3: ");
        int level = scan.nextInt();
        Structure Grid = new Structure(level);
        Grid.printGrid();
        do{
            System.out.println("Choose a cell to play");
            System.out.print("row: ");
            int row = scan.nextInt();
            System.out.print("column: ");
            int column = scan.nextInt();
            Grid.move(row - 1, column - 1);
            Grid.printGrid();
        } while (!Grid.isFinal());

        System.out.println("YOU WIN!");
        scan.close();
    }

}