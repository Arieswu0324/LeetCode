package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTTree {
    public static void main(String[] args) {
        BSTTree instance = new BSTTree();
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;

//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(8);
//        node2.left = node3;
//        node2.right = node4;
        System.out.println(instance.isValidBST(root));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            if (val > root.val) {
                return searchBST(root.right, val);
            } else if (val < root.val) {
                return searchBST(root.left, val);
            } else {
                return root;
            }
        }

        return null;

    }

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST2(TreeNode root) {
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            if (Integer.compare(list.get(i), list.get(i - 1)) >= 0) {
                return false;
            }
        }

        return true;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);

    }

    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;

        boolean right = isValidBST(root.right);
        return left && right;

    }

    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }

        traversal(node.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(pre.val - node.val));
        }
        pre = node;
        traversal(node.right);

    }

    //common binary tree
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }


        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);


        if (left == null && right == null) {
            return null;
        }

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;

    }


    //BST:第一次遇到 cur节点是数值在[q, p]区间中，那么cur就是 q和p的最近公共祖先。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }

        return root;

    }


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        return traversal(root, val);
    }

    private TreeNode traversal(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val > val) {
            TreeNode left = insertIntoBST(root.left, val);
            if (left == null) {
                left = new TreeNode(val);
            }
            root.left = left;
        }

        if (root.val < val) {
            TreeNode right = insertIntoBST(root.right, val);
            if (right == null) {
                right = new TreeNode(val);
            }
            root.right = right;
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            //左右都不为0，选择某一个子树继承，比如左子树继承:把右子树，放到左子树的最大节点处
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = root.right;
            return root.left;//左子树继承
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }

        if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }

        // root在[low,high]范围内
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int midIndex = nums.length / 2;

        TreeNode node = new TreeNode(nums[midIndex]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, midIndex));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, midIndex + 1, nums.length));
        return node;

    }



}
