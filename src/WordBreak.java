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
}
