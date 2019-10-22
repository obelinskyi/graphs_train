public class Node2<T> {
    private T data;
    private Node2[] neighbors;

    public Node2(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node2[] getNeighbours() {
        return neighbors;
    }

    public void setNeighbours(Node2[] neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "data=" + data +
                '}';
    }
}
