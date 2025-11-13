import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NQueens {

   List<List<String>> res = new ArrayList<>();
   char[][] chessboard;
    public List<List<String>> solveNQueens(int n) {
        chessboard = new char[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                chessboard[i][j]='.';
            }
        }

        backTracking(chessboard,n,0);
        return res;
    }
    private void backTracking(char[][] chessboard, int n, int row){
        if(row == n){
            res.add(Arrays.stream(chessboard)
                    .map(String::new)  // 将char[]转换为String
                    .collect(Collectors.toList()));
            return;
        }

        for(int i = 0; i< n; i++){
            if(isValid(chessboard, row, i,n)){
                    chessboard[row][i] = 'Q';
                    backTracking(chessboard, n, row+1);
                    chessboard[row][i] = '.';
            }

        }
    }

    private boolean isValid(char[][] chessboard, int row, int col, int n){
        for (int i = 0; i<n; i++){
            if(chessboard[i][col]== 'Q'){
                return false;
            }
        }

        for (int j = 0; j<n; j++){
            if(chessboard[row][j]== 'Q'){
                return false;
            }
        }

        if(row>=1&&col>=1){
            if(chessboard[row - 1][col - 1]== 'Q'){
                return false;
            }
        }

        if(row>=1 && col+1< n){
            if(chessboard[row-1][col+1]=='Q'){
                return false;
            }
        }

        if(col >=1 && row+1<n){
            if(chessboard[row+1][col-1]=='Q'){
                return false;
            }
        }

        if(row+1<n && col+1<n) {
            if (chessboard[row + 1][col + 1]== 'Q') {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        NQueens instance = new NQueens();
        List<List<String>> res = instance.solveNQueens(4);
        res.forEach(System.out::println);
    }
}
