package round2;

public class BinaryTreeCameras {

    int count = 0;

    public int minCameraCover(TreeNode root) {
        if (traversal(root) == 0) {
            count++;
        }
        ;
        return count;
    }

    //0:无覆盖，1：无相机，有覆盖，2：有相机
    private int traversal(TreeNode node) {
        if (node == null) {
            return 1;//叶子结点不按相机
        }
        int left = traversal(node.left);
        int right = traversal(node.right);

        //贪心：优先级
        if (left == 0 || right == 0) {
            count++;
            return 2;
        }

        if (left == 2 || right == 2) {
            return 1;
        }


        return 0;
    }
}
