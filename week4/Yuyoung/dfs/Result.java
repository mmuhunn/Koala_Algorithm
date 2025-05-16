package week4.Yuyoung.dfs;

import java.util.List;

class Result {

    // 방향 벡터 (8방향)
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int n, m;
    static boolean[][] visited;

    public static int maxRegion(List<List<Integer>> grid) {
        n = grid.size();
        m = grid.get(0).size();
        visited = new boolean[n][m];

        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1 && !visited[i][j]) {
                    int size = dfs(grid, i, j);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize;
    }

    private static int dfs(List<List<Integer>> grid, int x, int y) {
        visited[x][y] = true;
        int size = 1;

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                    grid.get(nx).get(ny) == 1 && !visited[nx][ny]) {
                size += dfs(grid, nx, ny);
            }
        }

        return size;
    }
}


