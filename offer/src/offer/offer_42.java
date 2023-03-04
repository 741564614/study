package offer;

import java.util.Arrays;

public class offer_42 {
    public int maxSubArray20(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, prefix[j] - prefix[i] + nums[i]);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new offer_42().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //以i为结尾的最大子数组和
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int maxSubArray30(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0, min = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            if (sum < min) {
                min = sum;
            }
        }
        return max;
    }
}
