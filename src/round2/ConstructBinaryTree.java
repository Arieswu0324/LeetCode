package round2;

import java.util.Arrays;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        ConstructBinaryTree instance = new ConstructBinaryTree();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3,9,20,15,7};
        instance.buildTree(inorder, preorder);

    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        int mid = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(mid);
        int index = findIndex(inorder, mid);

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, index);
        int[] rightPostorder = Arrays.copyOfRange(postorder, index + 1, postorder.length - 1);

        root.left = buildTree2(leftInorder, leftPostorder);
        root.right = buildTree2(rightInorder, rightPostorder);
        return root;

    }

    private int findIndex(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }

        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode mid = new TreeNode(preorder[0]);
        int index = findIndex(inorder, preorder[0]);

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, index+1);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, index + 1, preorder.length);

        mid.left = buildTree(leftPreorder, leftInorder);
        mid.right = buildTree(rightPreorder, rightInorder);
        return mid;

    }

}
