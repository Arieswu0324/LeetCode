import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTIterator {

    private final List<TreeNode> list = new ArrayList<>();
    private TreeNode cur;
    private int index;

    public BSTIterator(TreeNode root) {
        cur = root;
        inorder(cur);
        index = 0;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }

    public int next() {
        TreeNode node = list.get(index);
        index++;
        return node.val;
    }

    public boolean hasNext() {
        return index + 1 <= list.size();
    }
}
