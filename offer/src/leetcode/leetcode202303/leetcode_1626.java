package leetcode.leetcode202303;

import java.util.Arrays;

public class leetcode_1626 {
    public int bestTeamScore02(int[] scores, int[] ages) {
        int n = scores.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> {
            if (ages[a] == ages[b]) {
                return scores[a] - scores[b];
            }
            return ages[a] - ages[b];
        });
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <i; j++) {
                if (scores[index[i]] >= scores[index[j]]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += scores[index[i]];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
