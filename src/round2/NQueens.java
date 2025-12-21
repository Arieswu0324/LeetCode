package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {

    public static void main(String[] args) {
        NQueens instance = new NQueens();
        List<List<String>> lists = instance.solveNQueens(4);
        lists.forEach(list -> {
            String join = String.join(",", list);
            System.out.println(join);
        });
    }

    List<List<String>> res = new ArrayList<>();
    char[][] board;
    boolean[][] visited;
    int N;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        board = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], '.');
        }

        backtracking(board, 0);
        return res;
    }

    private void backtracking(char[][] board, int row) {
        if (row == N) {
            List<String> list = Arrays.stream(board)
                    .map(String::new) // 对每一行调用 String 构造函数
                    .collect(Collectors.toList());
            res.add(list);
        }

        for (int i = 0; i < N; i++) {
            if (isValid(i, row)) {
                board[row][i] = 'Q';
                backtracking(board, row + 1);
                board[row][i] = '.';
            }
        }

    }

    private boolean isValid(int col, int row) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


}
