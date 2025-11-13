import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);
        int res = 0;

        for (int i = 0; i < len; i++) {
            int h = citations[i];
            int freq = len - i;
            if (h >= freq) {
                res = Math.max(freq, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HIndex instance = new HIndex();
        int[] citations = {100};
        System.out.println(instance.hIndex(citations));
    }
}
