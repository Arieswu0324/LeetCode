import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIteratorWithStack {

    private final Deque<TreeNode> stack;
    TreeNode cur;

    public BSTIteratorWithStack(TreeNode root) {
        stack= new ArrayDeque<>();
        cur = root;
    }

    public int next() {
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }

        TreeNode node = stack.pop();
        cur = cur.right;
        return node.val;
    }

    public boolean hasNext() {
        return cur!=null || !stack.isEmpty();
    }
}
