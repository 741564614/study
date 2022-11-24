package leetcode.leetcode202211;

import java.util.Stack;

public class leetcode_795 {
    public static void main(String[] args) {
        System.out.println(new leetcode_795().numSubarrayBoundedMax02(new int[]{2, 9, 2, 5, 6}, 2, 8));
    }

    public int numSubarrayBoundedMax02(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    public int count(int[] nums, int lower) {
        int sum = 0, cut = 0;
        for (int num : nums) {
            cut = num <= lower ? cut + 1 : 0;
            sum += cut;
        }
        return sum;
    }


}
