package offer;

import java.util.Arrays;

public class offer_63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int max = 0;
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - dp[i - 1], max);
            dp[i] = Math.min(dp[i - 1], prices[i]);
        }
        return max;
    }

    public int maxProfit20(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - min, max);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
