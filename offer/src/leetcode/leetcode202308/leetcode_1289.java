package leetcode.leetcode202308;

import java.util.Arrays;

public class leetcode_1289 {
    public int minFallingPathSum02(int[][] grid) {
        int n = grid.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < grid[0].length; i++) {
            f[0][i] = grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        min = Math.min(min, f[i - 1][k]);
                    }
                }
                f[i][j] = min + grid[i][j];
            }
        }
        return Arrays.stream(f[n - 1]).min().getAsInt();
    }
}
