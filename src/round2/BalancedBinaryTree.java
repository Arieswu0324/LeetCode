package round2;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        node3.right = node6;
        BalancedBinaryTree instance = new BalancedBinaryTree();
        System.out.println(instance.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        return getH(root) != -1;
    }


    private int getH(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getH(node.left);
        if (left == -1) {
            return -1;
        }
        int right = getH(node.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
