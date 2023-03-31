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
}
