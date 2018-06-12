/**
 *  最长公共子序列LCS
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "abcffggcbda";
        String Y = "adbcggffcba";
        char[] arr1 = X.toCharArray();
        char[] arr2 = Y.toCharArray();
        System.out.println(lcs(arr1, arr2, arr1.length, arr2.length));
    }

    // 动态规划求解LCS问题
    // LCS for X[0, ... , m-1], Y[0, ... , n-1]
    public static int lcs(char[] X, char[] Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (X[i - 1] == Y[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


    // 简单递归求解LCS问题
    // return the length of LCS for X[0, ... , m-1] and Y[0, ... , n-1]
    public static int lcs1(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (X[m - 1] == Y[n - 1])
            return lcs1(X, Y, m - 1, n - 1) + 1;
        else
            return Math.max(lcs1(X, Y, m - 1, n), lcs1(X, Y, m, n - 1));
    }
}