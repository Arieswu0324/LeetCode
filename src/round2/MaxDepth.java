package round2;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return traversal(root);
    }

    private int traversal(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = traversal(node.left) + 1;
        int right = traversal(node.right) + 1;

        return Math.max(left, right);
    }


}
