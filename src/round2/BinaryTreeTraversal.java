package round2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeTraversal {
    List<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        return list;
    }


    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        preorder(root);
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        postorder(root);
        return list;
    }

    //左右中
    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }

    //中左右
    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        int size = 0;
        if (root != null) {
            queue.addLast(root);
            size++;
        }
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int count = 0;
            while (size > 0) {
                TreeNode node = queue.removeFirst();
                layer.add(node.val);
                size--;

                if (node.left != null) {
                    queue.addLast(node.left);
                    count++;
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                    count++;
                }

            }
            res.add(layer);
            size = count;
        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        int size = 0;
        if (root != null) {
            queue.addLast(root);
            size++;
        }
        while (!queue.isEmpty()) {
            int count = 0;
            while (size > 0) {
                TreeNode node = queue.removeFirst();
                if (size == 1) {
                    res.add(node.val);
                }
                size--;

                if (node.left != null) {
                    queue.addLast(node.left);
                    count++;
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                    count++;
                }

            }
            size = count;
        }
        return res;

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        int size = 0;
        if (root != null) {
            queue.addLast(root);
            size++;
        }
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int count = 0;
            while (size > 0) {
                TreeNode node = queue.removeFirst();
                layer.add(node.val);
                size--;

                if (node.left != null) {
                    queue.addLast(node.left);
                    count++;
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                    count++;
                }

            }
            double avg = (double) layer.stream().mapToLong(Integer::longValue).sum() / layer.size();
            res.add(avg);
            size = count;
        }
        return res;

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();

        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            while (size > 0) {
                Node node = queue.removeFirst();
                layer.add(node.val);
                size--;
                for (Node leaf : node.children) {
                    if (leaf != null) {
                        queue.addLast(leaf);
                    }
                }
            }
            res.add(layer);

        }

        return res;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode node = queue.removeFirst();
                max = Math.max(max, node.val);
                size--;

                if (node.left != null) {
                    queue.addLast(node.left);
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                }

            }
            res.add(max);

        }

        return res;

    }


}
