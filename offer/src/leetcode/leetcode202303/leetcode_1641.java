package leetcode.leetcode202303;

import java.util.Arrays;

public class leetcode_1641 {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        while (n-- > 1) {
            for (int i = 1; i < 5; i++) {
                dp[i] += dp[i - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }

    class Solution {
        public int countVowelStrings(int n) {
            return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
        }
    }

}
