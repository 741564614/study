package leetcode.leetcode202306;

public class leetcode_2460 {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && nums[i] == nums[i + 1] && nums[i] != 0) {
                ans[l++] = nums[i] * 2;
                nums[i + 1] = 0;
            } else if (nums[i] != 0) {
                ans[l++] = nums[i];
            }
        }
        return ans;
    }
}
