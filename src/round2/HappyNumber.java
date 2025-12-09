package round2;

import java.util.HashSet;
import java.util.Set;

//Input: n = 19
//Output: true
//Explanation:
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Long> set = new HashSet<>();
        long next = calculate(n);

        while (!set.contains(next)) {
            if (next == 1) {
                return true;
            }
            set.add(next);
            next = calculate(next);
        }

        return false;
    }

    private long calculate(long n) {
        long sum = 0;

        //19
        while (n != 0) {
            long t = n % 10;// t = 9,1
            sum += t * t; //sum = 9*9 + 1*1
            n /= 10;//n = 1, 0
        }

        return sum;
    }
}
