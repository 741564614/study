package leetcode.leetcode202209;

import java.util.Arrays;

public class leetcode_1608 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length;
        while (l < r) {
            int target = l + (r - l) / 2;
            int nl = 0, nr = nums.length;
            while (nl < nr) {
                int mid = nl + (nr - nl) / 2;
                if (nums[mid] >= target) {
                    nr = mid;
                } else {
                    nl = mid + 1;
                }
            }
            if (nums.length - nl == target) {
                return target;
            } else if (nums.length - nl > target) {
                l = target + 1;
            } else {
                r = target;
            }
        }
        return l == r && nums[0] >= l ? l : -1;
    }
}
