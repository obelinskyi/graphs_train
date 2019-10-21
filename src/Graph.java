public class Graph {

    public static void main(String[] args) {
        Node<String> A = new Node<>("A");
        Node<String> B = new Node<>("B");
        Node<String> C = new Node<>("C");
        Node<String> D = new Node<>("D");
        Node<String> E = new Node<>("E");
        Node<String> F = new Node<>("F");

        A.setNeighbours(new Node[]{B, C, D});
        B.setNeighbours(new Node[]{A, F});
        C.setNeighbours(new Node[]{A, D, F});
        D.setNeighbours(new Node[]{A, B, C, F});
        E.setNeighbours(new Node[]{C});
        F.setNeighbours(new Node[]{B, D});
        
        for (Node node : new Node[]{A, B, C, D, E, F}) {

        }
    }

}
