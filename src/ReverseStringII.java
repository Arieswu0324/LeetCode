import java.util.Arrays;

public class ReverseStringII {
    public static String reverse(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(chars.length - 1, start + k - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverse(s,2));
    }
}
