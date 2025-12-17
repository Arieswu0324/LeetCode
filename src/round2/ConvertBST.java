package round2;

public class ConvertBST {
    TreeNode pre = null;

    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.right);

        if (pre != null) {
            node.val += pre.val;
        }
        pre = node;

        inorder(node.left);
    }
}
