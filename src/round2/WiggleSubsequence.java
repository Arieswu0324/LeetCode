package round2;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int count = 1;
        if (nums.length == 1) {
            return count;
        }
        int pre = nums[1] - nums[0];

        for (int i = 2; i < nums.length; i++) {
            int cur = nums[i] - nums[i - 1];
            if (cur * pre < 0) {
                count++;
                pre = cur;
            } else {
                pre += cur;
            }
        }

        return pre == 0 ? count : count + 1;
    }
}
