package round2;

public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        return traversal(root.left, root.right);
    }

    private boolean traversal(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null) {
            return false;
        }

        if (right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return traversal(left.left, right.right) && traversal(left.right, right.left);
    }
}
