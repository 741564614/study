package leetcode.leetcode202303;

public class offer_47 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    int left = j >= 1 ? dp[i][j - 1] : 0;
                    int up = i >= 1 ? dp[i - 1][j] : 0;
                    dp[i][j] = Math.max(left, up) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int maxValue20(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
