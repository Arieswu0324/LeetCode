package round2;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    public static void main(String[] args) {
        RestoreIP instance = new RestoreIP();
        List<String> list = instance.restoreIpAddresses("101023");
        System.out.println(list.size());
    }
    List<List<String>> res = new ArrayList<>();
    List<String> parts = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0);
        return res.stream().map(list -> String.join(".", list)).toList();
    }

    private void backtracking(String s, int start) {
        //Base Case（递归终止条件）破坏了回溯的**“借用与归还”契约
        if (parts.size() == 3) {
            String last = s.substring(start);
            if (isValidIP(last)) {
                parts.add(last);
                res.add(new ArrayList<>(parts));
                parts.removeLast();
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String p = s.substring(start, i + 1);
            if (isValidIP(p)) {
                parts.add(p);
                backtracking(s, i + 1);
                parts.removeLast();
            }
        }
    }

    //只有数字，不考虑负数s consists of digits only.
    private boolean isValidIP(String s) {
        if(s.isEmpty()){
            return false;
        }
        if (s.length() >= 4) {
            return false;
        }

        //Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }

        if (Integer.parseInt(s) > 255) {
            return false;
        }

        return true;

    }
}
