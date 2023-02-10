package leetcode.leetcode202302;

import java.util.Arrays;

public class leetcode_1223 {
    class Solution02 {
        private static final long MOD = (long) 1e9 + 7;
        private int[] rollMax;
        private int[][][] cache;

        public int dieSimulator02(int n, int[] rollMax) {
            this.rollMax = rollMax;
            int m = rollMax.length;
            cache = new int[n][m][15];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; ++j)
                    Arrays.fill(cache[i][j], -1); // -1 表示没有访问过
            long ans = 0;
            for (int j = 0; j < m; ++j)
                ans += dfs(n - 1, j, rollMax[j] - 1);
            return (int) (ans % MOD);
        }

        private int dfs(int i, int last, int left) {
            if (i == 0) return 1;
            if (cache[i][last][left] >= 0) return cache[i][last][left];
            long res = 0;
            for (int j = 0; j < rollMax.length; ++j)
                if (j != last) res += dfs(i - 1, j, rollMax[j] - 1);
                else if (left > 0) res += dfs(i - 1, j, left - 1);
            return cache[i][last][left] = (int) (res % MOD);
        }
    }


    public int dieSimulator03(int n, int[] rollMax) {
        int[][][] dp = new int[n + 1][6][16];
        for (int i = 0; i < 6; i++) {
            dp[1][i][1] = 1;
        }
        int mod = (int) (1e9 + 7);

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= rollMax[j]; k++) {
                    for (int p = 0; p < 6; p++) {
                        if (p != j) {
                            dp[i][p][1] = (dp[i][p][1] + dp[i - 1][j][k]) % mod;
                        } else if (k + 1 <= rollMax[j]) {
                            dp[i][p][k + 1] = (dp[i][p][k + 1] + dp[i - 1][p][k]) % mod;
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int j = 0; j < 6; j++) {
            for (int k = 1; k <= rollMax[j]; k++) {
                res = (res + dp[n][j][k]) % mod;
            }
        }
        return res;
    }

}
