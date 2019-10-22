import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node<T> {
    private T data;
    private List<Node> neighbours;

    Node(T data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public Node[] getNeighbours() {
        return this.neighbours.toArray(new Node[0]);
    }

    public void setNeighbours(Node[] neighbours) {
        this.neighbours.addAll(Arrays.asList(neighbours));
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data + '}';
    }
}
