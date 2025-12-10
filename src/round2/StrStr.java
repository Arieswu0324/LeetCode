package round2;

public class StrStr {

    public int strStr(String haystack, String needle) {
        int[] lps = getLps(needle.toCharArray());
        int res = -1;
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    res = i - needle.length();
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

    private int[] getLps(char[] s) {
        int[] lps = new int[s.length];
        int i = 1;
        int len = 0;
        while (i < s.length) {
            if (s[i] == s[len]) {
                len++;
                lps[i] = len;
                i++;
            } else if (len == 0) {
                lps[i] = 0;
                i++;
            } else {
                len = lps[len - 1];//否则回退到前一个字符
            }
        }
        return lps;
    }
}
