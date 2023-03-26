package leetcode.leetcode202303;

import java.util.HashSet;
import java.util.Set;

public class leetcode_2395 {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int res = nums[i] + nums[i - 1];
            if (!set.add(res)) {
                return true;
            }
        }
        return false;
    }
}
