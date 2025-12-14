package round2;

public class SumOfLeftLeaves {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traversal(root);
        return sum;
    }

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }


        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }

        traversal(node.left);

        traversal(node.right);

    }
}
