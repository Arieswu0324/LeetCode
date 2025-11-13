public class SpiralMatrixII {

    public static int[][] spiralMatrix(int n) {
        //- 上从左到右：i 不变，j 增加
        //- 右从上到下：j不变，i 增加
        //- 下从右到左：i不变，j减少
        //- 左从下到上：j不变，i减少
        //左开右闭，最后一个元素不处理
        int start = 0;
        int offset = 1;
        int count = 1;
        int k = n;
        int[][] res = new int[n][n];
        while (k >1) {
            int j;
            int i;
            for (j = start; j < n - offset; j++) {
                res[start][j] = count;
                count++;
            }

            for (i = start; i < n - offset; i++) {
                res[i][n - offset] = count;
                count++;
            }

            for (; j > start; j--) {
                res[i][j] = count;
                count++;
            }

            for (; i > start; i--) {
                res[i][j] = count;
                count++;
            }
            k = k - 2;
            offset++;
            start++;
        }

        if(n%2==1){
            res[start][start] = count;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] res = spiralMatrix(n);
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(res[i][j]).append(" ");
            }
            System.out.println(s);
        }
    }
}
