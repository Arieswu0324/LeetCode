package round2;

public class RepeatedSubStringPattern {

    public boolean repeatedSubstringPattern2(String s) {
        int len = s.length();
        int mid = len / 2;
        String[] patterns = new String[mid];//前缀组
        for (int i = 0; i < mid; i++) {
            patterns[i] = s.substring(0, i + 1);
        }

        for (int i = 0; i < mid; i++) {
            //对每一个patter, match
            if (len % patterns[i].length() != 0) {
                continue;
            }
            StringBuilder builder = new StringBuilder();
            while (builder.length() < s.length()) {
                builder.append(patterns[i]);
            }
            if (builder.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }

    //要刨除 s + s 的首字符和尾字符，这样避免在s+s中搜索出原来的s，我们要搜索的是中间拼接出来的s。
    public boolean repeatedSubstringPattern3(String s) {
        StringBuilder builder = new StringBuilder(s);
        builder.append(s);
        return builder.substring(1, 2 * s.length() - 1).contains(s);
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] lps = getLps(s.toCharArray());
        int len = s.length() - lps[s.length() - 1];
        return lps[s.length()-1] >0 && s.length() % len == 0;

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
                i++; //回退到0
            } else {
                len = lps[len - 1];
            }
        }

        return lps;
    }
}
