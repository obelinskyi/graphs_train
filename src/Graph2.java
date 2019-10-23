import java.util.*;

public class Graph2 {

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
        List<List<Node>> groups = new ArrayList<>();
        for (Node node : nodes) {
            boolean is_grouped = groups.stream().flatMap(Collection::stream)
                    .anyMatch(e -> e.equals(node));
            if (!is_grouped) {
//                groups.add(getGroups(node));
                groups.add(depthFirtsSearch(node));
            }
        }
        groups.forEach(System.out::println);

    }

    static List<Node> getGroups(Node startingNode) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> visited = new ArrayList<>();
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

    static List<Node> depthFirtsSearch(Node startingNode) {
        Stack<Node> stack = new Stack<>();
        List<Node> visited = new ArrayList<>();
        stack.push(startingNode);
        visited.add(startingNode);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            for (Node neighbor : current.getNeighbours()) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return visited;
    }

}
