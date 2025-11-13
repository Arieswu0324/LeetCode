public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        //移除空格
        char[] ch = s.toCharArray();
        ch = removeSpaces(ch);

        //翻转字符串
        reverse(ch, 0, ch.length - 1);

        //翻转单词
        int start = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                reverse(ch, start, i - 1);
                start = i + 1;
            }
            if (i == ch.length - 1) {
                reverse(ch, start, i);
            }
        }

        return new String(ch);
    }

    public static String reverseWords1(String s){
        char[] ch = s.toCharArray();
        ch = removeSpaces(ch);
        reverse(ch, 0, ch.length-1);
        int start = 0;
        int end = 0;
        while(end < ch.length){
            if(ch[end]==' '){
                reverse(ch, start, end-1);
                start = end+1;
                end = start;
            }else if(end == ch.length-1){
                reverse(ch, start, end);
                start = end+1;
                end = start;

            }else{
                end++;
            }
        }

        return new String(ch);
    }

    public static char[] removeSpaces(char[] ch) {
        int slow = 0;
        int fast = 0;
        while (fast < ch.length) {
            if (ch[fast] != ' ') {
                if (slow != 0) {
                    ch[slow] = ' ';
                    slow++;
                }
                while (fast < ch.length && ch[fast] != ' ') {
                    ch[slow++] = ch[fast++];
                }
            }
            fast++;
        }

        char[] newChars = new char[slow];
        System.arraycopy(ch, 0, newChars, 0, slow);
        return newChars;
    }

    public static char[] removeSpaces1(char[] ch) {
        int i = 0;
        int j = 0;
        while (j < ch.length) {
            if (ch[j] != ' ') {
                if (i > 0 && ch[j - 1] == ' ') {
                    ch[i] = ' ';
                    i++;
                }
                ch[i] = ch[j];
                i++;
                j++;
            } else {
                j++;
            }
        }
        char[] newCh = new char[i];
        System.arraycopy(ch, 0, newCh, 0, i);
        return newCh;
    }

    public static void reverse(char[] ch, int left, int right) {
        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        String s = "  the sky    is blue  ";
        System.out.println(reverseWords1(s));

    }
}
