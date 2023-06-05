package leetcode.leetcode202306;

import java.util.*;
import java.util.Set;

public class leetcode_2465 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>();
        int l = 0, r = nums.length - 1;
        while (l < r) {
            set.add((nums[l++] + nums[r--]) / 2.0);
        }
        return set.size();
    }
}
