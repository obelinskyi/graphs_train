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
            boolean found = groups.stream().flatMap(Collection::stream).anyMatch(e -> e == node);
            if (!found) {
                groups.add(getGroup(node, nodes));
            }
        }
        groups.forEach(System.out::println);

    }

    static List<Node> getGroup(Node startingNode, List<Node> nodes) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> visited = new ArrayList<>();
        queue.add(startingNode);
        visited.add(startingNode);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node node : current.getNeighbours()) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    queue.add(node);
                }
            }
        }
        return visited;
    }

}
