import java.util.ArrayList;
import java.util.List;

public class WaterFlow {
    private static final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, m-1);
        }

        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, n-1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;

    }

    private void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextx = x + direction[i][0];
            int nexty = y + direction[i][1];

            if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) {
                continue;
            }

            if (grid[x][y] <= grid[nextx][nexty] && !visited[nextx][nexty]) {
                dfs(grid, visited, nextx, nexty);
            }
        }


    }
}
