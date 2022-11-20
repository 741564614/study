package leetcode.leetcode202211;

public class leetcode_799 {
    public double champagneTower02(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 10][query_row + 10];
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] <= 1) {
                    continue;
                }
                dp[i + 1][j] += (dp[i][j] - 1) / 2;
                dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
            }
        }
        return Math.min(dp[query_row][query_glass], 1);
    }
}
