package round2;

public class Sudoku {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }


    private boolean backtracking(char[][] board) {


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') { // 跳过原始数字
                    continue;
                }
                for (char n = '1'; n <= '9'; n++) {
                    if (isValid(i, j, n, board)) {
                        board[i][j] = n;
                        if (backtracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }

        }

        return true;
    }


    private boolean isValid(int x, int y, char n, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == n) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][y] == n) {
                return false;
            }
        }

        //子3x3
        int startx = x / 3 * 3;
        int starty = y / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startx + i][starty + j] == n) {
                    return false;
                }
            }
        }


        return true;
    }
}
