package round2;


import java.util.ArrayList;
import java.util.List;


public class PartitionLabels {
    //从头遍历字符，并更新字符的最远出现下标，
    // 如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] array = new int[27];
        int cut = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, array[s.charAt(i) - 'a']);
            if (max == i) {
                res.add(i - cut + 1);
                cut = i + 1;
            }
        }

        return res;
    }
}
