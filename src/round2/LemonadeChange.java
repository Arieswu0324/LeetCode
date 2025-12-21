package round2;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : bills) {
            if (!canChange(n, map)) {
                return false;
            }
        }

        return true;

    }

    private boolean canChange(int bill, Map<Integer, Integer> money) {
        if (bill == 5) {
            money.put(bill, money.getOrDefault(5, 0) + 1);
            return true;
        }

        if (bill == 10) {
            if (money.containsKey(5) && money.get(5) >= 1) {
                money.put(5, money.get(5) - 1);
                money.put(bill, money.getOrDefault(10, 0) + 1);
                return true;
            } else {
                return false;
            }
        }

        if (bill == 20) {
            if (money.containsKey(10) && money.get(10) >= 1 && money.containsKey(5) && money.get(5) >= 1) {
                money.put(5, money.get(5) - 1);
                money.put(10, money.get(10) - 1);
                money.put(20, money.getOrDefault(20, 0) + 1);
                return true;
            } else if (money.containsKey(5) && money.get(5) >= 3) {
                money.put(5, money.get(5) - 3);
                money.put(20, money.getOrDefault(20, 0) + 1);
                return true;
            }
            return false;
        }

        return false;
    }
}
