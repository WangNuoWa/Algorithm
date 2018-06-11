
/* 最长递增子序列*/
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 1, 2, 8};
        for (int i = 1; i <= arr.length; i++) {
            System.out.println(lis(arr, i));
        }
    }

    // LIS for arr[0, ... ,n-1]
    public static int lis(int[] arr, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;

            }
        }
        return dp[n - 1];
    }
}

