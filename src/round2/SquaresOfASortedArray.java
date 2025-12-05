package round2;

public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {

        int[] res = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int p = right;

        while (p >= 0) {
            int ls = nums[left] * nums[left];
            int rs = nums[right] * nums[right];

            if (ls > rs) {
                res[p] = ls;
                left++;
            } else {
                res[p] = rs;
                right--;
            }
            p--;
        }

        return res;
    }
}
