package round2;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning instance = new PalindromePartitioning();
        List<List<String>> res = instance.partition("abcd");
        res.forEach(list -> {
            String join = String.join(",", list);
            System.out.println(join);
        });
    }

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    //a,a,b
    //a, ab
    //aa, b
    //aab

    private void backtracking(String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isPalindrome(sub)) {
                path.add(sub);
                backtracking(s, i + 1);
                path.removeLast();
            }

        }

    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


}
