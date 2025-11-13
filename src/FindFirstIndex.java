import java.util.Arrays;

public class FindFirstIndex {

    public static int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        char[] t = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[] lps = getLps(p);
        int res = -1;
        while (i < t.length) {
            if (t[i] == p[j]) {
                i++;
                j++;
                if (j == p.length) {
                    res = i - p.length;
                    break;
                }
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j - 1];
            }
        }
        return res;
    }

    public static int[] getLps(char[] ch) {
        int[] lps = new int[ch.length];
        int i = 1;
        int len = 0;
        while (i < ch.length) {
            if (ch[i] == ch[len]) {
                len++;
                lps[i] = len;
                i++;
            } else if (len == 0) {
                lps[i] = 0;
                i++;
            } else {
                len = lps[len - 1];
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        char[] ch = {'a', 'b', 'a', 'c'};
        System.out.println(Arrays.toString(getLps(ch)));
        System.out.println(strStr("leetcode", "leeto"));
    }
}
