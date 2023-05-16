package leetcode.leetcode202305;

public class leetcode_1335 {
    public int minDifficulty02(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] memo = new int[d][n];
        memo[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            memo[0][i] = Math.max(memo[0][i - 1], jobDifficulty[i]);
        }
        for (int i = 1; i < d; i++) {
            for (int j = n - 1; j >= i; j--) {
                memo[i][j] = Integer.MAX_VALUE;
                int max = 0;
                for (int k = j; k >= i; k--) {
                    max = Math.max(max, jobDifficulty[k]);
                    memo[i][j] = Math.min(memo[i][j], memo[i - 1][k - 1] + max);
                }
            }
        }
        return memo[d - 1][n - 1];
    }
}
