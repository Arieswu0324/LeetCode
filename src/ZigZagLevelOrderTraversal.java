import com.sun.source.tree.Tree;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            reverse = !reverse;
            List<Integer> level = new LinkedList<>();
            while (size > 0) {//每一层
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (reverse) {
                    level.addFirst(node.val);
                } else {
                    level.addLast(node.val);
                }
                size--;
            }
            res.add(level);
        }
        return res;

    }


}
