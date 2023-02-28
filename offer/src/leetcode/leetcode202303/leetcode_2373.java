package leetcode.leetcode202303;

public class leetcode_2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ans[i][j] = find(i + 1, j + 1, grid);
            }
        }
        return ans;
    }

    public int find(int row, int col, int[][] grid) {
        int max = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
