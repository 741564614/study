package leetcode.leetcode202307;

import java.util.*;

public class leetcode_2050 {
    public int minimumTime02(int n, int[][] relations, int[] time) {
        ArrayList<Integer>[] mat = new ArrayList[n + 1];
        for (int[] relation : relations) {
            int prev = relation[0], next = relation[1];
            if (mat[next] == null) {
                mat[next] = new ArrayList<>();
            }
            mat[next].add(prev);
        }
        int[] note = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp(i, note, time, mat));
        }
        return max;
    }

    public int dp(int i, int[] note, int[] time, ArrayList<Integer>[] mat) {
        if (note[i] != 0) {
            return note[i];
        }
        int ans = 0;
        if (mat[i] != null) {
            for (Integer prev : mat[i]) {
                ans = Math.max(ans, dp(prev, note, time, mat));
            }
        }
        ans += time[i - 1];
        note[i] = ans;
        return ans;
    }
}
