package round2;

import java.util.Arrays;
import java.util.List;

public class MaxBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        List<Integer> pair = findMax(nums);
        int index = pair.getFirst();
        ;
        int val = pair.getLast();
        TreeNode root = new TreeNode(val);

        int[] left = Arrays.copyOfRange(nums, 0, index);
        int[] right = Arrays.copyOfRange(nums, index + 1, nums.length);

        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;

    }


    private List<Integer> findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return List.of(index, max);
    }
}
