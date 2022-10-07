package leetcode.leetcode202210;

public class leetcode_1800 {
    public int maxAscendingSum(int[] nums) {
        int max = 0, sum = 0, prev = 0;
        for (int num : nums) {
            if (prev == 0 || prev < num) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
            prev = num;
        }
        return max;
    }
}
