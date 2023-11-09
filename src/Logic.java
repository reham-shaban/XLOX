import javax.swing.plaf.PanelUI;
import java.util.*;

public class Logic {
    public void UserPlayer(State state){
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("Next States:");
            List<State> states = state.getNextState();

            System.out.println("Choose a move");
            System.out.print("row: ");
            int row = scan.nextInt();
            System.out.print("column: ");
            int column = scan.nextInt();

            state = state.move(row - 1, column - 1);
            System.out.println("Current Grid");
            state.printState();
            System.out.println();
        } while (!state.isFinal());

        System.out.println("YOU WIN!");
        scan.close();
    }

    public void printPath(Map<State, State> path, State currentState){
        Deque<State> stack = new LinkedList<>();
        while (currentState != null){
            stack.push(currentState);
            currentState = path.get(currentState);
        }
        int i = 1;
        stack.pop();
        while (!stack.isEmpty()){
            currentState = stack.pop();
            System.out.println("step: " + i);
            currentState.printState();
            System.out.println();
            i++;
        }
    }

    public void BFS(State currentState){
        int depth = 1;
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        Map<State, State> path = new HashMap<>();
        queue.add(currentState);
        while(!queue.isEmpty()){
            currentState = queue.poll();
            if(currentState.isFinal()){
                printPath(path, currentState);
                System.out.println("BFS depth: " + depth);
                break;
            }
            if(!visited.contains(currentState)){
                depth++;
                visited.add(currentState);
                List<State> nextStates = currentState.getNextState();
                for (State state : nextStates){
                    if (!visited.contains(state)) {
                        queue.add(state);
                        path.put(state, currentState);
                    }
                }
            }
        }



    }

    public void DFS(State currentState){
        int depth = 1;
        Deque<State> stack = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        Map<State, State> path = new HashMap<>();
        stack.push(currentState);
        while (!stack.isEmpty()){
            currentState = stack.pop();
            if(currentState.isFinal()){
                printPath(path, currentState);
                System.out.println("DFS depth: " + depth);
                break;
            }
            if(!visited.contains(currentState)){
                visited.add(currentState);
                List<State> nextStates = currentState.getNextState();
                for (State state : nextStates){
                    if (!visited.contains(state)) {
                        stack.add(state);
                        path.put(state, currentState);
                    }
                }
                depth++;
            }
        }
    }

    public void UCS(State currentState){

    }
}
