package round2;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = minDepth(root.left) + 1;
        }

        if (root.right != null) {
            right = minDepth(root.right) + 1;
        }

        if (left == 0) {
            return right;
        }

        if (right == 0) {
            return left;
        }

        return Math.min(left, right);

    }

}
