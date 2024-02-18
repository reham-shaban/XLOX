import javax.swing.plaf.PanelUI;
import java.util.*;

import static java.lang.Math.max;

public class Logic {
    public void UserPlayer(State state){
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("Choose a move");
            System.out.print("row: ");
            int row = scan.nextInt();
            System.out.print("column: ");
            int column = scan.nextInt();

            state = state.move(row - 1, column - 1);
            System.out.println("Current Grid with cost: " + state.getCost());
            state.printState();
            System.out.println();
        } while (!state.isFinal());

        System.out.println("YOU WIN!");
        scan.close();
    }

    public void printPath(Map<State, State> path, State currentState) {
        List<State> result = new ArrayList<>();
        while (currentState != null) {
            result.add(currentState);
            currentState = path.get(currentState);
        }
        Collections.reverse(result);
        int i = 0;
        for(State state : result){
            System.out.println("step: " + i);
            state.printState();
            System.out.println();
            i++;
        }
    }

    public void  BFS(State currentState){
        int graphSize = 1;

        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        Map<State, State> path = new HashMap<>();

        queue.add(currentState);
        while (!queue.isEmpty()){
            currentState = queue.poll();
            visited.add(currentState);
            List<State> nextStates = currentState.getNextState();

            for (State state : nextStates){
                if(state.isFinal()){
                    path.put(state, currentState);
                    printPath(path, state);
                    System.out.println("depth: " + state.getCost());
                    System.out.println("Graph size: " + graphSize);
                    System.out.println("Visited states: " + visited.size());
                    return;
                }
                if (!visited.contains(state) && !queue.contains(state)) {
                    queue.add(state);
                    graphSize++;
                    path.put(state, currentState);
                }
            }
        }
        System.out.println("No solution!");
    }

    public void DFS(State currentState){
        int graphSize = 1;

        Deque<State> stack = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        Map<State, State> path = new HashMap<>();

        stack.push(currentState);
        while (!stack.isEmpty()){
            currentState = stack.pop();
            visited.add(currentState);
            List<State> nextStates = currentState.getNextState();

            for (State state : nextStates){
                if(state.isFinal()){
                    path.put(state, currentState);
                    printPath(path, state);
                    System.out.println("depth: " + state.getCost());
                    System.out.println("Graph size: " + graphSize);
                    System.out.println("Visited states: " + visited.size());
                    return;
                }
                if(!visited.contains(state) && !stack.contains(state)){
                    stack.push(state);
                    graphSize++;
                    path.put(state, currentState);
                }
            }
        }
       System.out.println("No solution!");
    }

    public void UCS(State currentState){
        int graphSize = 1;

        PriorityQueue<State> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(State::getCost));
        Set<State> visited = new HashSet<>();
        Map<State, State> path = new HashMap<>();

        priorityQueue.add(currentState);

        while (!priorityQueue.isEmpty()) {
            currentState = priorityQueue.poll();
            visited.add(currentState);
            List<State> nextStates = currentState.getNextState();
            for (State state : nextStates) {
                if (state.isFinal()) {
                    path.put(state, currentState);
                    printPath(path, state);
                    System.out.println("depth: " + state.getCost());
                    System.out.println("Graph size: " + graphSize);
                    System.out.println("Visited states: " + visited.size());
                    return;
                }
                if (!priorityQueue.contains(state) && !visited.contains(state)) {
                    priorityQueue.add(state);
                    graphSize++;
                    path.put(state, currentState);
                }
            }
        }
        System.out.println("No solution!");
    }

    public void hillClimbing(State currentState) {
        int graphSize = 1;

        PriorityQueue<State> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(State::calculateHeuristic));
        Set<State> visited = new HashSet<>();
        Map<State, State> path = new HashMap<>();

        priorityQueue.add(currentState);

        while(!priorityQueue.isEmpty()){
            currentState = priorityQueue.poll();
            visited.add(currentState);
            List<State> nextStates = currentState.getNextState();
            for (State state : nextStates) {
                if (state.isFinal()) {
                    path.put(state, currentState);
                    printPath(path, state);
                    System.out.println("depth: " + state.getCost());
                    System.out.println("Graph size: " + graphSize);
                    System.out.println("Visited states: " + visited.size());
                    return;
                }
                if (!priorityQueue.contains(state) && !visited.contains(state)) {
                    priorityQueue.add(state);
                    graphSize++;
                    path.put(state, currentState);
                }
            }
        }
        System.out.println("No solution!");
    }

    public void Astar(State currentState){
        int graphSize = 1;

        PriorityQueue<State> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(State::totalCost));
        Set<State> visited = new HashSet<>();
        Map<State, State> path = new HashMap<>();

        priorityQueue.add(currentState);

        while (!priorityQueue.isEmpty()) {
            currentState = priorityQueue.poll();
            visited.add(currentState);
            List<State> nextStates = currentState.getNextState();
            for (State state : nextStates) {
                if (state.isFinal()) {
                    path.put(state, currentState);
                    printPath(path, state);
                    System.out.println("depth: " + state.getCost());
                    System.out.println("Graph size: " + graphSize);
                    System.out.println("Visited states: " + visited.size());
                    return;
                }
                if (!priorityQueue.contains(state) && !visited.contains(state)) {
                    priorityQueue.add(state);
                    graphSize++;
                    path.put(state, currentState);
                }
            }
        }
        System.out.println("No solution!");
    }

}

