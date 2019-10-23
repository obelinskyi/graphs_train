import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Node2<T> {

    private T data;
    private List<Node> neighbours;

    public Node2(T data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node[] getNeighbours() {
        return neighbours.toArray(new Node[0]);
    }

    public void setNeighbours(Node[] neighbours) {
        this.neighbours = Arrays.stream(neighbours).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Node2{" +
                "data=" + data +
                '}';
    }
}