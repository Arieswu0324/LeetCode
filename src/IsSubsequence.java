public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];//t 中的第到第i-1的位置得到的s的子序列长度
        int res = 0;
        for(int i = 1; i<=t.length();i++){
            for(int j = 1; j<=s.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
            res = Math.max(dp[s.length()][i], res);
        }
        return res == s.length();
    }
}
