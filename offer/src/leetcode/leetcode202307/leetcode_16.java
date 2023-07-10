package leetcode.leetcode202307;

import java.util.Arrays;

public class leetcode_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int value = nums[i] + nums[left] + nums[right];
                if (value == target) {
                    return target;
                } else if (value > target) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(value - target) < diff) {
                    diff = Math.abs(value - target);
                    ans = value;
                }
            }
        }
        return ans;
    }
}
