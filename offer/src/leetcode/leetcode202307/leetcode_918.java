package leetcode.leetcode202307;

public class leetcode_918 {
    public int maxSubarraySumCircular02(int[] nums) {
        int len = nums.length, max = nums[0],
                min = nums[0], sum = nums[0],
                fmax = nums[0], fmin = nums[0];
        for (int i = 1; i < len; i++) {
            fmax = Math.max(fmax + nums[i], nums[i]);
            max = Math.max(max, fmax);
            fmin = Math.min(fmin + nums[i], nums[i]);
            min = Math.min(min, fmin);
            sum += nums[i];
        }
        return max < 0 ? max : Math.max(max, sum - min);
    }

    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            int[] leftMax = new int[n];
            // 对坐标为 0 处的元素单独处理，避免考虑子数组为空的情况
            leftMax[0] = nums[0];
            int leftSum = nums[0];
            int pre = nums[0];
            int res = nums[0];
            for (int i = 1; i < n; i++) {
                pre = Math.max(pre + nums[i], nums[i]);
                res = Math.max(res, pre);
                leftSum += nums[i];
                leftMax[i] = Math.max(leftMax[i - 1], leftSum);
            }

            // 从右到左枚举后缀，固定后缀，选择最大前缀
            int rightSum = 0;
            for (int i = n - 1; i > 0; i--) {
                rightSum += nums[i];
                res = Math.max(res, rightSum + leftMax[i - 1]);
            }
            return res;
        }
    }

}
