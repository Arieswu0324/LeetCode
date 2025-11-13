
public class DFS {


    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'Z';
                dfs(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = 'Z';
                dfs(board, i, n - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'Z';
                dfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                board[m - 1][i] = 'Z';
                dfs(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='Z'){
                    board[i][j]='O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextx = x + direction[i][0];
            int nexty = y + direction[i][1];
            if (nextx < 0 || nextx >= board.length || nexty < 0 || nexty >= board[0].length) {
                continue;
            }

            if (board[nextx][nexty] == 'O') {
                board[nextx][nexty] = 'Z';
                dfs(board, nextx, nexty);
            }
        }
    }


    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }




    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'X'}
        };


        solve(grid);

    }
}
