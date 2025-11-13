public class RightReverse {
    public static String rightReverse(String s, int k) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        for (int i = 0; i < k; i++) {
            char temp = ch[len - 1];
            for (int j = len - 1; j > 0; j--) {
                ch[j] = ch[j - 1];
            }
            ch[0] = temp;
        }
        return new String(ch);
    }

    public static String rightReverse2(String s, int k){
        char[] ch = s.toCharArray();
        ReverseWordsInAString.reverse(ch, 0, s.length()-1);
        ReverseWordsInAString.reverse(ch,0,k-1);
        ReverseWordsInAString.reverse(ch,k,s.length()-1);
        return new String(ch);
    }

    public static void main(String[] args) {
        String s = "abcdefg";

        System.out.println(rightReverse2(s, 2));
    }
}
