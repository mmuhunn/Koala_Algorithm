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
public class Dijkstra_Shortest_Reach2 {
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            List edge = edges.get(i);
            int u = (int) edge.get(0);
            int v = (int) edge.get(1);
            int weight = (int) edge.get(2);
            graph.get(u).add(new Node(v, weight));
            graph.get(v).add(new Node(u, weight));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.vertex;
            if (visited[u]) continue;
            visited[u] = true;

            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int w = neighbor.cost;
                if (!visited[v] && dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            result.add(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }
        return result;
    }
}
