package leetcode.leetcode202303;

import java.util.HashSet;
import java.util.Set;

public class leetcode_2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        boolean[] check = new boolean[210];
        for (int num : nums) {
            check[num] = true;
            if (num - 2 * diff >= 0 && check[num - diff] && check[num - 2 * diff]) {
                ans++;
            }
        }
        return ans;
    }

    class Solution {
        public int arithmeticTriplets(int[] nums, int diff) {
            int ans = 0;
            int n = nums.length;
            for (int i = 0, j = 1, k = 2; i < n - 2 && j < n - 1 && k < n; i++) {
                j = Math.max(j, i + 1);
                while (j < n - 1 && nums[j] - nums[i] < diff) {
                    j++;
                }
                if (j >= n - 1 || nums[j] - nums[i] > diff) {
                    continue;
                }
                k = Math.max(k, j + 1);
                while (k < n && nums[k] - nums[j] < diff) {
                    k++;
                }
                if (k < n && nums[k] - nums[j] == diff) {
                    ans++;
                }
            }
            return ans;
        }
    }

}
