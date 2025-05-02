package week4.shinhyung;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

class Result {

    /*
     * Complete the 'maxRegion' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY grid as parameter.
     */

    public static int maxRegion(List<List<Integer>> grid) {
        // Write your code here
        int n = grid.size();           // number of row grid
        int m = grid.get(0).size();    // number of colomn grid
        boolean[][] visited = new boolean[n][m];  // visitied
        int maxSize = 0;

        for (int i = 0; i < n; i++) {           // all row
            for (int j = 0; j < m; j++) {       // all coloumn
                if (!visited[i][j] && grid.get(i).get(j) == 1) {
                    int size = 0;               // initialize

                    Stack<int[]> stack = new Stack<>();          // DFS
                    stack.push(new int[]{i, j});                 //
                    visited[i][j] = true;                         //


                    while (!stack.isEmpty()) {
                        int[] cell = stack.pop();                //
                        int r = cell[0];                         //
                        int c = cell[1];                         //
                        size++;                                  //


                        for (int dr = -1; dr <= 1; dr++) {
                            for (int dc = -1; dc <= 1; dc++) {
                                int nr = r + dr;
                                int nc = c + dc;


                                if ((dr != 0 || dc != 0) && nr >= 0 && nr < n && nc >= 0 && nc < m) {
                                    if (!visited[nr][nc] && grid.get(nr).get(nc) == 1) {
                                        stack.push(new int[]{nr, nc});
                                        visited[nr][nc] = true;
                                    }
                                }
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] gridRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> gridRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowTempItems[j]);
                gridRowItems.add(gridItem);
            }

            grid.add(gridRowItems);
        }

        int res = Result.maxRegion(grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}