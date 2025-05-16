package week4.Yuyoung.bfs;

import java.util.*;

class Result {

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // 인접 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);  // 무방향 그래프
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1); // 초기값 -1: 방문하지 않음
        Queue<Integer> queue = new LinkedList<>();
        dist[s] = 0;
        queue.add(s);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[current] + 6;
                    queue.add(neighbor);
                }
            }
        }

        // 결과에서 시작 노드를 제외한 리스트 생성
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                result.add(dist[i]);
            }
        }

        return result;
    }
}
