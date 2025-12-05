package round2;

import java.util.Arrays;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix instance = new SpiralMatrix();
        int[][] res = instance.generateMatrix(2);
        Arrays.stream(res).map(array -> {
                    Arrays.stream(array).forEach(System.out::println);
                    return null;
                }
        );
    }

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int k = 1;
        int x = 0;//圈数
        while (k <= n * n) {
            int i = x;
            int j = x;

            for (j = x; j < n - x - 1; j++) {//j = 0; i<n-1; j++
                res[i][j] = k++;
            }

            for (i = x; i < n - x - 1; i++) {//
                res[i][j] = k++;
            }

            for (j = n - x - 1; j > x; j--) {
                res[i][j] = k++;
            }

            for (i = n - x - 1; i > x; i--) {
                res[i][j] = k++;
            }

            x++;
            if (k == n * n) {
                res[n / 2][n / 2] = k;
                break;
            }
        }

        return res;

    }
}
