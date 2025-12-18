package round2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneNumberComb {

    public static void main(String[] args) {
        PhoneNumberComb instance = new PhoneNumberComb();
        List<String> list = instance.letterCombinations("23");
        System.out.println(list.size());
    }

    Map<String, List<String>> map = new HashMap<>();
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    //23
    public List<String> letterCombinations(String digits) {
        map.put("2", List.of("a", "b", "c"));
        map.put("3", List.of("d", "e", "f"));
        map.put("4", List.of("g", "h", "i"));
        map.put("5", List.of("j", "k", "l"));
        map.put("6", List.of("m", "n", "o"));
        map.put("7", List.of("p", "q", "r", "s"));
        map.put("8", List.of("t", "u", "v"));
        map.put("9", List.of("w", "x", "y", "z"));

        int len = digits.length();
        backtracking(digits, len, 0);
        return res.stream().map(list -> {
            return String.join("", list);
        }).toList();

    }

    private void backtracking(String digits, int len, int start) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (start >= len) {
            return;
        }
        //a,b,c
        //d,e,f
        List<String> list = map.get(String.valueOf(digits.charAt(start)));
        for (String s : list) {
            path.add(s);
            backtracking(digits, len, start + 1);
            path.removeLast();
        }
    }
}
