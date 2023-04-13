package leetcode.leetcode202304;

import java.util.Arrays;

public class leetcode_2404 {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int ans = -1, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                int cnt = 1;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                    cnt++;
                }
                if (cnt > max) {
                    max = cnt;
                    ans = nums[i];
                }
            }
        }
        return ans;
    }

    public int mostFrequentEven20(int[] nums) {
        int[] cnt = new int[50001];
        int ans = -1, max = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                int cur = ++cnt[num >> 1];
                if (cur > max) {
                    ans = num;
                    max = cur;
                } else if (cur == max && num < ans) {
                    ans = num;
                }
            }
        }
        return ans;
    }
}
