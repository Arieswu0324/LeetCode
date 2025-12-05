package round2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RangSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] preSum = new int[n];
        preSum[0] = sc.nextInt();

        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + sc.nextInt();
        }
        List<Integer> res = new ArrayList<>();
        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            res.add(sum(preSum, a, b));
        }
        res.forEach(System.out::println);
    }

    private static int sum(int[] nums, int a, int b) {
        if (a == 0) {
            return nums[b];
        } else {
            return nums[b] - nums[a - 1];
        }
    }
}
