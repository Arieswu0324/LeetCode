import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PalindromePartition {
    List<List<String>> res = new ArrayList<>();
    List<String> pal = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return res;
    }

    private  void backtracking(String s, int startIndex){
        if(startIndex == s.length()){
            res.add(new ArrayList<>(pal));
            return;
        }
        for(int i = startIndex; i< s.length(); i++){
            String sub = s.substring(startIndex, i+1);
            if(isPalindrome(sub)){
                pal.add(sub);
            }else {
                continue; //继续下一轮循环
            }

            backtracking(s, i+1);
            if(!pal.isEmpty()){
                pal.removeLast();
            }
        }

    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartition instance = new PalindromePartition();
        List<List<String>> res = instance.partition("aab");
        res.forEach(System.out::println);
    }
}
