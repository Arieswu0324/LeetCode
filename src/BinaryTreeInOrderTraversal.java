import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInOrderTraversal {

    public static List<Integer> inOrderTraversal(TreeNode root) {
      List<Integer>  list = new ArrayList<>();

        traverse(root, list);

        return list;
    }

    public static List<Integer> inOrderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

  private static void traverse(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
      traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node.right = node1;
        node1.left = node2;
        System.out.println(inOrderTraversal(node));
    }
}
