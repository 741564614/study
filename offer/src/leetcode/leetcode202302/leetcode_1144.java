package leetcode.leetcode202302;

public class leetcode_1144 {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int[] change = new int[2];
        for (int i = 0; i < n; i++) {
            int cost = 0;
            //中间部分
            if (i - 1 >= 0 && i + 1 < n && (nums[i] >= nums[i - 1] || nums[i] >= nums[i + 1])) {
                cost = Math.abs(nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1);
            }
            //最后一个
            else if (i - 1 >= 0 && nums[i] >= nums[i - 1]) {
                cost = Math.abs(nums[i] - nums[i - 1] + 1);
            }
            //第一个
            else if (i + 1 < n && nums[i] >= nums[i + 1]) {
                cost = Math.abs(nums[i] - nums[i + 1] + 1);
            }
            //奇大->偶变,偶大->奇变
            change[i % 2] += cost;
        }
        return Math.min(change[0], change[1]);
    }
}
