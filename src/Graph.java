import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    public static void main(String[] args) {
        Node<String> A = new Node<>("A");
        Node<String> B = new Node<>("B");
        Node<String> C = new Node<>("C");
        Node<String> D = new Node<>("D");
        Node<String> E = new Node<>("E");
        Node<String> F = new Node<>("F");
        Node<String> G = new Node<>("G");
        Node<String> H = new Node<>("H");
        Node<String> I = new Node<>("I");
        Node<String> J = new Node<>("J");

        A.setNeighbours(new Node[]{B, E});
        B.setNeighbours(new Node[]{A, E});
        C.setNeighbours(new Node[]{D});
        D.setNeighbours(new Node[]{C});
        E.setNeighbours(new Node[]{A, B, F});
        F.setNeighbours(new Node[]{E});
        G.setNeighbours(new Node[]{H, I});
        H.setNeighbours(new Node[]{G, J});
        I.setNeighbours(new Node[]{G, J});
        J.setNeighbours(new Node[]{H, I});
        List<Node> nodes = Arrays.asList(new Node[]{A, B, C, D, E, F, G, H, I, J});

        Map<Node, Boolean> traversed = breadthSearchFirst(A, nodes);
        System.out.println("Is graph connected(breadthSearchFirst): " + !traversed.containsValue(false) + "\n" + traversed);

        List<Node> traversed2 = depthFirstSearch(A, nodes);
        System.out.println("Is graph connected(depthFirstSearch): " + traversed2.equals(nodes) + "\n" + traversed2);


        List<List<Node>> groups = new ArrayList<>();
        for (Node node : nodes) {
            boolean grouped = false;
            for (List<Node> group : groups) {
                if (group.contains(node)) {
                    grouped = true;
                    break;
                }
            }
            if (!grouped) {
                groups.add(getGroup(node, nodes));
            }
        }
        System.out.println();
        groups.forEach(System.out::println);
    }

    static List<Node> getGroup(Node startingNode, List<Node> nodes) {
        List<Node> visited = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(startingNode);
        visited.add(startingNode);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.getNeighbours()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    @NotNull
    static Map<Node, Boolean> breadthSearchFirst(Node startingNode, @NotNull List<Node> Nodes) {
        Map<Node, Boolean> visited = new HashMap<>();
        for (Node Node : Nodes) visited.put(Node, false);
        Queue<Node> queue = new LinkedList<>();
        queue.add(startingNode);
        visited.put(startingNode, true);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.getNeighbours()) {
                if (!visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    static List<Node> depthFirstSearch(Node startingNode, @NotNull List<Node> Nodes) {
        List<Node> visited = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(startingNode);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                stack.addAll(Arrays.asList(current.getNeighbours()));
            }
        }
        return visited;
    }
}
