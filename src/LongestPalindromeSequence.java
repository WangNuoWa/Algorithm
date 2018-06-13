
/* 最长回文子序列LPS*/
public class LongestPalindromeSequence {
    public static void main(String[] args) {
        String s = "abcffggcbda";
        char[] chars = s.toCharArray();
        System.out.println(lps(chars, chars.length));
    }

    //动规求LPS, X[0,1, ..., n-1]
    private static int lps(char[] X, int n) {
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {  // 递推式dp[i][j]需要用到dp[i+1][j],所以逆序i
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (X[i] == X[j])
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }

    // 先逆序， 然后求原始串和逆序串的最公共子序列


}
