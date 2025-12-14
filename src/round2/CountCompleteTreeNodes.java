package round2;

public class CountCompleteTreeNodes {
    int count;
    public int countNodes(TreeNode root) {
        count = 0;
        traversal(root);
        return count;
    }

    private void traversal(TreeNode node){
        if(node == null){
            return;
        }
        count++;
        traversal(node.left);
        traversal(node.right);
    }

    public int countNodes2(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftH = 0;
        int rightH = 0;
        while(left!=null){
            leftH++;
            left = left.left;

        }
        while(right!=null){
            rightH++;
            right = right.right;

        }

        if(leftH == rightH){
            return (2<<leftH) -1;
        }

        int leftC = countNodes(root.left);
        int rightC = countNodes(root.right);
        return leftC + rightC +1;

    }

}
