package round2;

import java.util.*;

public class FindModesInBST {

    Map<Integer, Integer> map;
    List<Integer> res;
    int max = 1;

    public int[] findMode2(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        inorder2(root);

        return map.entrySet().stream().filter(entry ->
                entry.getValue().equals(max)
        ).map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
    }


    private void inorder2(TreeNode node) {
        if (node == null) {
            return;
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        max = Math.max(max, map.get(node.val));
        inorder2(node.left);
        inorder2(node.right);
    }


    List<Integer> list;
    TreeNode pre=null;
    int count=1;
    int maxCount = 1;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        //1,1,2,2,3,3,3
        inorder(node.left);

        if (pre != null && pre.val == node.val) {
            count++;
        }else {
            count=1;
        }

        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(node.val);
        }else if(maxCount==count){
            res.add(node.val);
        }

        pre = node;

        inorder(node.right);
    }

}
