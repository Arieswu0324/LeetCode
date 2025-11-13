public class IslandPerimeter {
    private static final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nextx = i + direction[k][0];
                        int nexty = j + direction[k][1];

                        if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m || grid[nextx][nexty] == 0) {
                            res++;
                        }
                    }
                }
            }
        }

        return res;

    }


}
