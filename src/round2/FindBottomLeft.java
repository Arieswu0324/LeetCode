package round2;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeft {
    //return the leftmost value in the last row of the tree.
    //其实就是深度最大的叶子节点一定是最后一行，但要保证优先搜索左边，才能找到最左值


    public int findBottomLeftValue2(TreeNode root) {
        int res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        res = root.val;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.removeFirst();
                size--;

                if (node.left != null) {
                    queue.addLast(node.left);
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                }

            }
            if (!queue.isEmpty()) {
                res = queue.peek().val;
            }
        }
        return res;
    }

    int max = Integer.MIN_VALUE;
    int h = 0;
    int value;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        traversal(root);
        return value;
    }

    private void traversal(TreeNode node) {
        if (node.left ==null && node.right == null) {
            if (h > max) {
                max = h;
                value = node.val;
            }
            return;
        }


        if (node.left != null) {
            h++;
            traversal(node.left);
            h--;
        }

        if (node.right != null) {
            h++;
            traversal(node.right);
            h--;
        }
    }


}
