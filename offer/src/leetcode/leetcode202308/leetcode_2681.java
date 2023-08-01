package leetcode.leetcode202308;

import java.util.Arrays;

public class leetcode_2681 {
    public int sumOfPower02(int[] nums) {
        Arrays.sort(nums);
        int dp = 0, pre = 0;
        int ans = 0, mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            dp = (nums[i] + pre) % mod;
            pre = (pre + dp) % mod;
            ans = (int) ((ans + (long) nums[i] * nums[i] % mod * dp) % mod) % mod;
        }
        return ans;
    }
}
