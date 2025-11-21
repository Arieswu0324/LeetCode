public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {
        int len = s.length();

        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int start = 0;


        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }


                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }


        }

        return s.substring(start, start + maxLen);

    }


}
