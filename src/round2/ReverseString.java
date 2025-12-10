package round2;

public class ReverseString {
    public void reverseString(char[] s) {
        int n = s.length;
        int mid = n / 2;

        for (int i = 0; i <= mid; i++) {
            swap(s, i, n-1-i);
        }
    }

    private void swap(char[] s, int i, int j) {
        if(i==j){
            return;
        }
        char t;
        t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
