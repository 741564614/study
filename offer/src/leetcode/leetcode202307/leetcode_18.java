package leetcode.leetcode202307;

import java.util.*;

public class leetcode_18 {

    public static void main(String[] args) {
        int[] k=new int[]{1000000000,1000000000,1000000000,1000000000};
        System.out.println(new leetcode_18().fourSum(k,-294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    long value = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if (value == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < nums.length - 1 && nums[l] == nums[l + 1]) l++;
                        while (r > 0 && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (value > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
