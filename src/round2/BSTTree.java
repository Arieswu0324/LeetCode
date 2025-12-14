package round2;

import java.util.ArrayList;
import java.util.List;

public class BSTTree {
    public static void main(String[] args) {
        BSTTree instance = new BSTTree();
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;

//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(8);
//        node2.left = node3;
//        node2.right = node4;
        System.out.println(instance.isValidBST(root));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            if (val > root.val) {
                return searchBST(root.right, val);
            } else if (val < root.val) {
                return searchBST(root.left, val);
            } else {
                return root;
            }
        }

        return null;

    }

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST2(TreeNode root) {
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            if (Integer.compare(list.get(i), list.get(i - 1)) >= 0) {
                return false;
            }
        }

        return true;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);

    }

    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;

        boolean right = isValidBST(root.right);
        return left && right;

    }

    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }

    private void traversal(TreeNode node){
        if(node == null){
            return;
        }

        traversal(node.left);
        if(pre!=null){
            min = Math.min(min, Math.abs(pre.val-node.val));
        }
        pre = node;
        traversal(node.right);

    }

}
