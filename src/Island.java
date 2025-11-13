import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//最大岛屿面积
public class Island {

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();//row
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxIslandSize(grid));

    }

    static int res = 0;
    static int size = 0;

    private static int maxIslandSize(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    size = 0;
                    visited[i][j] = true;
                    bfs(grid, visited, i, j);//更新size
                    res = Math.max(res, size);
                }
            }
        }
        return res;
    }

    static List<Pair> queue = new ArrayList<>();

    public static void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        size++;
        queue.add(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair pair = queue.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nextx = pair.x + direction[i][0];
                int nexty = pair.y + direction[i][1];

                if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) {
                    continue;
                }

                if (grid[nextx][nexty] == 1 && !visited[nextx][nexty]){
                    visited[nextx][nexty] = true;
                    size++;
                    queue.add(new Pair(nextx, nexty));
                }

            }

        }
    }

}
