package leetcode.leetcode202302;

public class leetcode_1139 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0}};
        System.out.println(new leetcode_1139().largest1BorderedSquare(grid));
    }

    public int largest1BorderedSquare(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length - ans; i++) {
            for (int j = 0; j < grid[0].length - ans; j++) {
                int step = ans;
                while (i + step < grid.length && j + step < grid[0].length) {
                    if (check(i, j, grid, step)) {
                        ans = Math.max(ans, step + 1);
                    }
                    step++;
                }
            }
        }
        return ans * ans;
    }

    public boolean check(int i, int j, int[][] grid, int step) {
        if (i + step >= grid.length || j + step >= grid[0].length) {
            return false;
        }
        for (int t = 0; t < step; t++) {
            if (grid[i][j + t] == 0 || grid[i + t][j + step] == 0 || grid[i + step][j + step - t] == 0 || grid[i + step - t][j] == 0) {
                return false;
            }
        }
        return grid[i][j] == 1 && grid[i][j + step] == 1 && grid[i + step][j + step] == 1 && grid[i + step][j] == 1;
    }

    public int largest1BorderedSquare20(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    int step = Math.min(left[i][j], up[i][j]);
                    while (left[i - step + 1][j] < step || up[i][j - step + 1] < step) {
                        step--;
                    }
                    ans = Math.max(ans, step);
                }
            }
        }
        return ans * ans;
    }
}
