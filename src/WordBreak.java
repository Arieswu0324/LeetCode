import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //s是背包，dict是物品
        boolean[] dp = new boolean[s.length()+1];
        Set<String> set = new HashSet<>(wordDict);

        dp[0] = true;

        for(int i = 1; i<=s.length();i++){
            for(int j = 0; j<i;j++){
                String word = s.substring(i-j,i);
                if (set.contains(word) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }

    private List<String> path = new ArrayList<>();

    //Input: s = "leetcode", wordDict = ["leet","code"] 回溯算法会超时
    public boolean wordBreak2(String s, List<String> wordDict) {
        String newStr = constructStr(path);
        if (newStr.length() > s.length()) {
            return false;
        }

        if (newStr.equals(s)) {
            return true;
        }

        for (String word : wordDict) {
            path.add(word);
            boolean flag = wordBreak(s, wordDict);
            if (flag) {
                return true;
            }
            path.removeLast();
        }

        return false;
    }

    private String constructStr(List<String> path) {
        return String.join("", path);
    }
}
