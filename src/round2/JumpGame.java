package round2;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int cover = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i <= cover) {
                cover = Math.max(cover, i + nums[i]);
            }

            if (cover >= nums.length) {
                return true;
            }


        }

        return false;
    }


    public int jump(int[] nums) {
        int jump = 0;
        int n = nums.length;
        int max = 0;
        int cur = 0;
        //1,2,1,1,1

        if (nums.length == 1) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, i + nums[i]);

            if (i == cur) {
                jump++;
                cur = max;
                if (max >= n - 1) {
                    break;
                }
            }
        }

        return jump;
    }
}
