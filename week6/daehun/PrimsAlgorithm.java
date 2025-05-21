import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrimsAlgorithm {
    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Write your code here
        List<List<Edge>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int cost = edge.get(2);
            graph.get(u).add(new Edge(v, cost));
            graph.get(v).add(new Edge(u, cost));
        }

        boolean[] visited = new boolean[n+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int totalWeight = 0;

        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            int node = cur.w;
            int cost = cur.cost;

            if (visited[node]) continue;

            visited[node] = true;
            totalWeight += cost;

            for (Edge neighbor : graph.get(node)) {
                if(!visited[neighbor.w]) {
                    pq.add(new Edge(neighbor.w, neighbor.cost));
                }
            }
        }

        return totalWeight;
    }
}

class Edge implements Comparable<Edge>{
    int w;
    int cost;

    Edge(int w, int cost){
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost,o.cost);
    }
}