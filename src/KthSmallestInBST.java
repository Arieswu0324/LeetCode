import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestInBST {

    private int count;

    private int res;


    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inorder(root.left);
        }

        count--;
        if (count == 0) {
            res = root.val;
        }


        if (root.right != null) {
            inorder(root.right);
        }

    }

    public static void main(String[] args) {
        KthSmallestInBST instance = new KthSmallestInBST();
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        node.left = node1;
        node.right = node3;
        node1.right = node2;
        System.out.println(instance.kthSmallest(node, 2));
    }

}
