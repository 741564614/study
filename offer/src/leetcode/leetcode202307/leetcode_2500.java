package leetcode.leetcode202307;

import java.util.Arrays;

public class leetcode_2500 {
    public static void main(String[] args) {
        int[][] k = new int[][]{{1, 2, 4}, {3, 3, 1}};
        System.out.println(new leetcode_2500().deleteGreatestValue(k));
    }

    public int deleteGreatestValue(int[][] grid) {
        for (int[] g : grid) {
            Arrays.sort(g);
        }
        int ans = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }
        return ans;
    }
}
