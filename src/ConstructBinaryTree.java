import java.util.Arrays;

public class ConstructBinaryTree {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0){
            return null;
        }
        int val = postorder[postorder.length-1];
        TreeNode root = new TreeNode(val);
        if(postorder.length == 1){
            return root;
        }

        //cut inorder to find left-inorder and right-inorder
        int index = 0;
        for(int i = 0; i<inorder.length; i++){
            if(inorder[i] == val){
                index = i;
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0,index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
        System.out.println("-----In Order After Cut------");
        System.out.println(Arrays.toString(leftInorder));
        System.out.println(Arrays.toString(rightInorder));



        //cut postorder to find lef-postorder and right-postorder
        int[] leftPostrorder = Arrays.copyOfRange(postorder, 0,leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftPostrorder.length, postorder.length-1);

        System.out.println("-----Post Order After Cut------");
        System.out.println(Arrays.toString(leftPostrorder));
        System.out.println(Arrays.toString(rightPostorder));

        root.left = buildTree(leftInorder, leftPostrorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;

    }

    public static void main(String[] args) {
        int[] inorder = {2,1};
        int[] postorder={2,1};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println("-----------Result----------------");
        preorderTraversal(root);

    }

    public static void preorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        if(root.left!=null){
            preorderTraversal(root.left);
        }

        if(root.right!=null){
            preorderTraversal(root.right);
        }
    }
}
