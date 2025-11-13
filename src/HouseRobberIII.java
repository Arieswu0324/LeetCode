public class HouseRobberIII {
    public int rob(TreeNode root) {
            int[] res = robTree(root);
            return Math.max(res[0], res[1]);
    }

    private int[] robTree(TreeNode node){
        if(node==null){return new int[]{0,0};}

        int[] leftDp = robTree(node.left);
        int[] rightDp = robTree(node.right);

        int value1=Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);
        int value2= node.val + leftDp[0] + rightDp[0];

        return new int[]{value1, value2};

    }
}
