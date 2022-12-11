package leetcode.leetcode202212;

public class leetcode_1827 {
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += (nums[i - 1] + 1 - nums[i]);
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }

    public int minOperations20(int[] nums) {
        int ans = 0,prev=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                ans += (prev + 1 - nums[i]);
                prev+=1;
            }else{
                prev=nums[i];
            }
        }
        return ans;
    }
}
