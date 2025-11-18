public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;//这里判断的比较，这里题意中P,Q是存在在树里的节点，所以没有进行值的比较
        }//终止条件

        TreeNode left = lowestCommonAncestor(root.left, p, q);//左
        TreeNode right = lowestCommonAncestor(root.right, p, q);//右

        //中
        if (left != null && right != null) {
            return root;//找到公共祖先
        }
        if (left != null && right == null) {
            return left;//找到某个节点
        }
        if (left == null && right != null) {
            return right;//找到某个节点
        }

        return null;//没找到
    }


}
