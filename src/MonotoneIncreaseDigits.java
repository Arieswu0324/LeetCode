import java.util.Arrays;

public class MonotoneIncreaseDigits {
    public int monotoneIncreasingDigits(int n) {
        char[] s= String.valueOf(n).toCharArray();
        int flag = s.length;

        for(int i = s.length-1; i>0; i--){
            if(s[i] < s[i-1]){
                 s[i-1]--;
                 flag = i;
            }
        }

        for(int i = flag; i<s.length; i++){
            s[i]='9';
        }

        return Integer.parseInt(new String(s));

    }

    public static void main(String[] args) {
        MonotoneIncreaseDigits instance = new MonotoneIncreaseDigits();
        System.out.println(instance.monotoneIncreasingDigits(1234));
    }
}
