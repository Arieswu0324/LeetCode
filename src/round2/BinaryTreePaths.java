package round2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        node3.right = node6;
        BinaryTreePaths instance = new BinaryTreePaths();
        System.out.println(String.join("->", instance.binaryTreePaths(root)));
    }


    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traversal(root);
        return paths.stream().map(list ->
                list.stream().map(String::valueOf).collect(Collectors.joining(""))
        ).toList();
    }

    private void traversal(TreeNode root) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            paths.add(new ArrayList<>(path));
            return;
        }

        path.add(root.val);
        if (root.left != null) {
            traversal(root.left);
            path.removeLast();
        }


        if (root.right != null) {
            traversal(root.right);
            path.removeLast();
        }


    }
}
