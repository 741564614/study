package leetcode.leetcode202308;

public class leetcode_1267 {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] x = new int[m], y = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[i] += grid[i][j];
                y[j] += grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (x[i] > 1 || y[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
