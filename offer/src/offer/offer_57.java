package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class offer_57 {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        Set<Integer> set = new HashSet<>();
        while (nums[start] < target) {
            if (set.contains(target - nums[start])) {
                return new int[]{nums[start], target - nums[start]};
            }
            set.add(nums[start++]);
        }
        return new int[0];
    }

    public int[] twoSum20(int[] nums, int target) {
        int start = 0;
        while (nums[start] < target) {
            int end = Arrays.binarySearch(nums, target - nums[start]);
            if (end >= 0 && end < nums.length) {
                return new int[]{nums[start], nums[end]};
            }
            start++;
        }
        return new int[0];
    }

    public int[] twoSum02(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int now = nums[l] + nums[r];
            if (now < target) {
                l++;
            } else if (now > target) {
                r--;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return new int[0];
    }
}
