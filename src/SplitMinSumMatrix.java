import java.util.Arrays;

public class SplitMinSumMatrix {

    public static int split(int[][] nums, int n, int m) {
        int[] sumsN = new int[n]; //每一行的和
        int[] sumsM = new int[m]; //每一列的和

        int[] sumsN_sum = new int[n]; //行的前缀和
        int[] sumsM_sum = new int[m]; //列的前缀和

        for (int i = 0; i < n; i++) { //填充每一行的和
            int s = 0;
            for (int j = 0; j < m; j++) {
                s += nums[i][j];
            }
            sumsN[i] = s;
            sumsN_sum[i] = i==0? sumsN[i] : sumsN_sum[i - 1] + sumsN[i];
        }
//        System.out.println(Arrays.toString(sumsN));
//        System.out.println(Arrays.toString(sumsN_sum));

        int delta_n = Integer.MAX_VALUE;
        for (int p = 0; p < n; p++) {
            int p_pre = sumsN_sum[p]; //前面的和
            int p_aft = sumsN_sum[n - 1] - sumsN_sum[p];
             //后面的和
            int delta = p_pre - p_aft;
//           System.out.println(delta);
            delta_n = Math.min(Math.abs(delta_n), Math.abs(delta)); //横向切的最小差
        }


        for (int j = 0; j < m; j++) { //填充每一列的和
            int s = 0;
            for (int i = 0; i < m; i++) {
                s += nums[i][j];
            }
            sumsM[j] = s;
            sumsM_sum[j] = j==0? sumsM[j] : sumsM_sum[j - 1] + sumsM[j];
        }

//        System.out.println(Arrays.toString(sumsM));
//        System.out.println(Arrays.toString(sumsM_sum));

        int delta_m = Integer.MAX_VALUE;
        for (int q = 0; q < m; q++) {
            int p_pre = sumsM_sum[q]; //前面的和
            int p_aft = sumsM_sum[m - 1] - sumsM_sum[q]; //后面的和
            int delta = p_pre - p_aft;
//            System.out.println(delta);
//            System.out.println("pre: " +p_pre);
//            System.out.println("aft: "+p_aft);
            delta_m = Math.min(Math.abs(delta_m), Math.abs(delta)); //纵向切的最小差
        }

        return Math.min(Math.abs(delta_m), Math.abs(delta_n)); //横纵比较最小差
    }

    public static void main(String[] args) {
       int[][] nums = {{1, 2, 3}, {2, 1, 3}, {1, 2, 3}};
       System.out.println(split(nums, 3, 3));

        int[][] nums1 = {{1,2},{3,4}};
        System.out.println(split(nums1,2,2));

        int[][] nums2 = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(split(nums2,3,3));

        int[][] num3 = {{1},{2},{3}};
        System.out.println(split(num3,3,1));
    }
}
