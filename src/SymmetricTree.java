public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (right == null && left != null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (right.val != left.val) {
            return false;
        }
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside&& inside;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        node.right = node1;
        node.left = node2;
        System.out.println(isSymmetric(node));
    }
}
