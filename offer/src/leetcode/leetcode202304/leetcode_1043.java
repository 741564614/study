package leetcode.leetcode202304;

public class leetcode_1043 {
    public int maxSumAfterPartitioning02(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        for (int i = 1; i <= arr.length; i++) {
            int maxValue = arr[i-1];
            for (int j = i - 1; j >= (i - k) && j >= 0; j--) {
                maxValue = Math.max(maxValue, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + maxValue * (i - j));
            }
        }
        return dp[arr.length];
    }

    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int[] d = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int maxValue = arr[i - 1];
                for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                    d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
                    if (j > 0) {
                        maxValue = Math.max(maxValue, arr[j - 1]);
                    }
                }
            }
            return d[n];
        }
    }
}
