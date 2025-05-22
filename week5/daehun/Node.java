public class Node implements Comparable<Node>{
    int vertex, cost;

    Node(int v, int c) {
        this.vertex = v;
        this.cost = c;
    }
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}
