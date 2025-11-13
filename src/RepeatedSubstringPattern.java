public class RepeatedSubstringPattern {
    public static boolean isRepeated(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.append(s);
        String substring = sb.substring(1, s.length() * 2 - 1);
        return substring.contains(s);

    }

    public static boolean isRepeatedByKMP(String s) {
        int[] lps = FindFirstIndex.getLps(s.toCharArray());
        int len = s.length() - lps[s.length() - 1];
        return lps[s.length() - 1] > 0 && s.length() % len == 0;
    }

    public static void main(String[] args) {
        //System.out.println(isRepeated("abcabc"));
        //System.out.println(isRepeatedByKMP("abcabc"));
        //System.out.println(isRepeated("aba"));
        System.out.println(isRepeatedByKMP("abac"));
    }
}
