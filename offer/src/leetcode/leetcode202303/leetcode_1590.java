package leetcode.leetcode202303;

import java.util.*;

public class leetcode_1590 {

    public static void main(String[] args) {
        int[] nums = new int[]{8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2};
        System.out.println(new leetcode_1590().minSubarray0_2(nums, 148));
    }

    public int minSubarray0_2(int[] nums, int p) {
        int sum = 0;
        for (int num : nums) {
            sum = (num + sum) % p;
        }
        int mod = sum % p;
        if (mod == 0) {
            return 0;
        }
        int ans = nums.length, prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            map.put(prefix, i);
            if (map.containsKey((prefix - mod + p) % p)) {
                ans = Math.min(ans, i - map.get((prefix - mod + p) % p));
            }
        }
        return ans == nums.length ? -1 : ans;
    }

    public int minSubarray02(int[] nums, int p) {
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) {
            return 0;
        }
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        int y = 0, res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            index.put(y, i); // f[i] mod p = y，因此哈希表记录 y 对应的下标为 i
            y = (y + nums[i]) % p;
            if (index.containsKey((y - x + p) % p)) {
                res = Math.min(res, i - index.get((y - x + p) % p) + 1);
            }
        }
        return res == nums.length ? -1 : res;
    }
}
