import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappyNumber(int n) {
        int a = n;
        Set<Integer> set = new HashSet<>();

        while (true) {
            int sum = 0;
            while (a > 0) {
                int m = a % 10;
                sum += m * m;
                a = a / 10;
            }
            if (set.contains(sum)) {
                return false;
            } else if (sum == 1) {
                return true;
            } else {
                set.add(sum);
                a = sum;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(19));
        System.out.println(isHappyNumber(2));
        System.out.println(isHappyNumber(31));
    }
}
