


//深度搜索找到每一个岛屿，染色并记录面积-> map
//遍历每一个0位置，判断如果当前位置为1，加上周边岛屿得到的面积是多少
//周边岛屿的遍历不能重->set
//返回最大面积


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {

    private static final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private Map<Integer, Integer> map = new HashMap<>();
    int size = 0;
    int mark = 2;//染色标记

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    size = 0;
                    dfs(grid, i, j);//标记
                    map.put(mark, size);
                    mark++;
                }

            }
        }

        // 如果整个网格都是水
        if (map.isEmpty()) return 1;

        // 如果整个网格都是陆地
        if (map.size() == 1 && map.get(2) == n * n) return n * n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    size = 1;
                    for (int k = 0; k < 4; k++) {
                        int nextx = i + direction[k][0];
                        int nexty = j + direction[k][1];

                        if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) {
                            continue;
                        }

                        if (set.contains(grid[nextx][nexty])) {
                            continue;
                        }

                        if (map.containsKey(grid[nextx][nexty])) {
                            size += map.get(grid[nextx][nexty]);
                            set.add(grid[nextx][nexty]);
                        }
                    }
                }

                res = Math.max(res, size);
            }
        }
        return res == 0 ? n * n : res;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (grid[x][y] != 1) {
            return;
        }

        grid[x][y] = mark;
        size++;
        for (int k = 0; k < 4; k++) {
            int nextx = x + direction[k][0];
            int nexty = y + direction[k][1];

            if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) {
                continue;
            }

            dfs(grid, nextx, nexty);

        }

    }
}
