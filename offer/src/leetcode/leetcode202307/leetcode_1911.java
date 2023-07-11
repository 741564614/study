package leetcode.leetcode202307;

public class leetcode_1911 {
    public long maxAlternatingSum02(int[] nums) {
        long cur = nums[0], prev = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur, prev + nums[i]);
            prev = Math.max(prev, cur - nums[i]);
        }
        return cur;
    }
}
