package round2;

public class PathSum {

    public static void main(String[] args) {
        PathSum instance = new PathSum();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        //TreeNode node2 = new TreeNode(2);
        root.left = node1;
        //root.right = node2;
        System.out.println(instance.hasPathSum(root, 1));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        //int newTargetSum = targetSum - root.val;，
        // 但这个 newTargetSum 是一个局部变量。当函数返回时，它会被销毁，不会影响到调用它的上层函数中的 targetSum
        int nextTarget = targetSum- root.val;

        //hasPathSum 函数不需要显式回溯，因为它没有修改任何共享状态
        return hasPathSum(root.left, nextTarget) || hasPathSum(root.right, nextTarget);
    }


}
