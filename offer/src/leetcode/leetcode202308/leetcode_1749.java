package leetcode.leetcode202308;

import java.util.Arrays;

public class leetcode_1749 {

    public static void main(String[] args) {
        int[] k = new int[]{-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9};
        System.out.println(new leetcode_1749().maxAbsoluteSum(k));
        System.out.println(Arrays.stream(new int[]{-2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9}).sum());
    }

    public int maxAbsoluteSum(int[] nums) {
        int dp = 0, dpm = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            dpm = Math.min(dpm + nums[i], nums[i]);
            ans = Math.max(ans, Math.max(dp, -dpm));
        }
        return ans;
    }

    public int maxAbsoluteSum02(int[] nums) {
        int sum = 0, max = 0, min = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        return max - min;
    }
}
