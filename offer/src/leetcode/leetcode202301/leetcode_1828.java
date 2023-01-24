package leetcode.leetcode202301;

import java.util.Arrays;

public class leetcode_1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = count(points, queries[i]);
        }
        return ans;
    }

    public int count(int[][] points, int[] q) {
        int ans = 0;
        for (int[] point : points) {
            int x = q[0] - point[0];
            int y = q[1] - point[1];
            int r = q[2];
            if (x * x + y * y <= r * r) {
                ans++;
            }
        }
        return ans;
    }

}
