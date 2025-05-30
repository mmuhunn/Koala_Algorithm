import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int prims(int n, List<List<Integer>> edges, int start) {
        
        List<List<int[]>> graph = new ArrayList<List<int[]>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<int[]>());
        }

        
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // Prim's algorithm
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        pq.offer(new int[]{start, 0});
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (visited[node]) continue;
            visited[node] = true;
            totalWeight += weight;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];
                if (!visited[nextNode]) {
                    pq.offer(new int[]{nextNode, edgeWeight});
                }
            }
        }

        return totalWeight;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<List<Integer>>();

        for (int i = 0; i < m; i++) {
            String[] edgeInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> edge = new ArrayList<Integer>();
            for (int j = 0; j < 3; j++) {
                edge.add(Integer.parseInt(edgeInput[j]));
            }
            edges.add(edge);
        }

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
