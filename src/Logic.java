import java.util.Scanner;
import java.util.List;

public class Logic {
    public void UserPlayer(State state){
        Scanner scan = new Scanner(System.in);
        state.printState();
        do{
            System.out.println("Next States:");
            List<State> states = state.getNextState();

            System.out.println("Choose a move");
            System.out.print("row: ");
            int row = scan.nextInt();
            System.out.print("column: ");
            int column = scan.nextInt();

            state = state.move(row - 1, column - 1);
            state.printState();
        } while (!state.isFinal());

        System.out.println("YOU WIN!");
        scan.close();
    }

}
