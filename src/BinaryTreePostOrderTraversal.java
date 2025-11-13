import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePostOrderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>  list = new ArrayList<>();

        traverse(root, list);

        return list;
    }

    public static List<Integer> postorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return res.reversed();
    }

    private static void traverse(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        traverse(root.left, list);
        traverse(root.right, list);
        list.add(root.val);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node.right = node1;
        node1.left = node2;
        System.out.println(postorderTraversal1(node));
    }
}
