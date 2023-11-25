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
        int depth = 0;

        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        Map<State, State> path = new HashMap<>();

        queue.add(currentState);
        while (!queue.isEmpty()){
            currentState = queue.poll();
            visited.add(currentState);
            List<State> nextStates = currentState.getNextState();
            depth++;
            for (State state : nextStates){
                if(state.isFinal()){
                    path.put(state, currentState);
                    printPath(path, state);
                    System.out.println("Graph depth: " + depth);
                    System.out.println("Visited states: " + visited.size());
                    return;
                }
                if (!visited.contains(state)) {
                    queue.add(state);
                    path.put(state, currentState);
                }
            }
        }
        System.out.println("No solution!");
    }

    public void DFS(State currentState){
        int depth = 0;

        Deque<State> stack = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        Map<State, State> path = new HashMap<>();

        stack.push(currentState);
        while (!stack.isEmpty()){
            currentState = stack.pop();
            visited.add(currentState);
            List<State> nextStates = currentState.getNextState();
            depth++;
            for (State state : nextStates){
                if(state.isFinal()){
                    path.put(state, currentState);
                    printPath(path, state);
                    System.out.println("Graph depth: " + depth);
                    System.out.println("Visited states: " + visited.size());
                    return;
                }
                if(!visited.contains(state)){
                    stack.push(state);
                    path.put(state, currentState);
                }
            }
        }
       System.out.println("No solution!");
    }

    public void UCS(State currentState){
        int depth = currentState.getCost();

        PriorityQueue<State> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(State::getCost));
        Set<State> visited = new HashSet<>();
        Set<State> graph = new HashSet<>();
        Map<State, State> path = new HashMap<>();

        priorityQueue.add(currentState);
        graph.add(currentState);

        while (!priorityQueue.isEmpty()) {
            currentState = priorityQueue.poll();
            visited.add(currentState);
            List<State> nextStates = currentState.getNextState();
            for (State state : nextStates) {
                if (state.isFinal()) {
                    depth = max(depth, state.getCost());
                    path.put(state, currentState);
                    printPath(path, state);
                    System.out.println("Graph size: " + graph.size());
                    System.out.println("depth: " + depth);
                    System.out.println("Visited states: " + visited.size());
                    return;
                }
                if (!graph.contains(state)) {
                    priorityQueue.add(state);
                    graph.add(state);
                    path.put(state, currentState);
                    depth = max(depth, state.getCost());
                }
            }
        }
        System.out.println("No solution!");
    }


    public void hillClimbing(State currentState) {
        int depth = currentState.getCost();

        PriorityQueue<State> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(State::calculateHeuristic));
        Set<State> visited = new HashSet<>();
        Set<State> graph = new HashSet<>();
        Map<State, State> path = new HashMap<>();

        priorityQueue.add(currentState);
        graph.add(currentState);
        while(!priorityQueue.isEmpty()){
            currentState = priorityQueue.poll();
            visited.add(currentState);
            List<State> nextStates = currentState.getNextState();
            for (State state : nextStates) {
                if (state.isFinal()) {
                    depth = max(depth, state.getCost());
                    path.put(state, currentState);
                    printPath(path, state);
                    System.out.println("Graph size: " + graph.size());
                    System.out.println("depth: " + depth);
                    System.out.println("Visited states: " + visited.size());
                    return;
                }
                if (!graph.contains(state)) {
                    priorityQueue.add(state);
                    graph.add(state);
                    path.put(state, currentState);
                    depth = max(depth, state.getCost());
                }
            }
        }
        System.out.println("No solution!");
    }

    public void Astar(State currentState){
        int depth = currentState.getCost();

        PriorityQueue<State> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(State::totalCost));
        Set<State> visited = new HashSet<>();
        Set<State> graph = new HashSet<>();
        Map<State, State> path = new HashMap<>();

        priorityQueue.add(currentState);
        graph.add(currentState);
        while (!priorityQueue.isEmpty()) {
            currentState = priorityQueue.poll();
            visited.add(currentState);
            List<State> nextStates = currentState.getNextState();
            for (State state : nextStates) {
                if (state.isFinal()) {
                    depth = max(depth, state.getCost());
                    path.put(state, currentState);
                    printPath(path, state);
                    System.out.println("Graph size: " + graph.size());
                    System.out.println("depth: " + depth);
                    System.out.println("Visited states: " + visited.size());
                    return;
                }
                if (!visited.contains(state)) {
                    priorityQueue.add(state);
                    graph.add(state);
                    path.put(state, currentState);
                    depth = max(depth, state.getCost());
                }
            }
        }
        System.out.println("No solution!");
    }

}

