package leetcode.leetcode202307;

import java.util.Arrays;

public class leetcode_2679 {
    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int n = nums[0].length, m = nums.length, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, nums[j][i]);
            }
            ans += max;
        }
        return ans;
    }
}
