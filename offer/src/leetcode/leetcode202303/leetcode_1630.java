package leetcode.leetcode202303;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        int m = l.length;
        for (int i = 0; i < m; i++) {
            ans.add(check(Arrays.copyOfRange(nums, l[i], r[i] + 1)));
        }
        return ans;
    }

    public boolean check(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != nums[1] - nums[0]) {
                return false;
            }
        }
        return true;
    }
}
