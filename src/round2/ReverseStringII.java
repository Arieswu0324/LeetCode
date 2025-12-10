package round2;

import java.util.Arrays;

public class ReverseStringII {
    public static void main(String[] args) {
        ReverseStringII instance = new ReverseStringII();

        System.out.println(instance.reverseStr("abcdefg", 2));
    }

    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();

        for (int i = 0; i < str.length; i += 2 * k) {
            int left = str.length - i;
            if (left < k) {
                reverse(str, i, str.length - 1);
            } else if (left < 2 * k || i % 2 == 0) {
                reverse(str, i, i + k - 1);
            }
        }

        return new String(str);

    }

    //左闭右闭
    private void reverse(char[] s, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }
}
