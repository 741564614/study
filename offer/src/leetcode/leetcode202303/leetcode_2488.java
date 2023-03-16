package leetcode.leetcode202303;

import java.util.HashMap;
import java.util.Map;

public class leetcode_2488 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 4, 5};
        System.out.println(new leetcode_2488().countSubarrays(nums, 4));
    }

    public int countSubarrays(int[] nums, int k) {
        int ans = 0, index = nums.length, prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                index = i;
            }
            int temp = nums[i] > k ? 1 : 0;
            prefix += temp;
            if (i <= index) {
                int key = 2 * prefix - i - 2 * temp;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int target = 2 * prefix - i;
            if (i >= index) {
                ans += map.getOrDefault(target, 0);
                ans += map.getOrDefault(target - 1, 0);
            }
        }

        return ans;
    }

    public int countSubarrays02(int[] nums, int k) {
        int index = 0, n = nums.length;
        // 找出k在nums中的下标index
        while (nums[index] != k) index++;
        // 用数组存储比k大或小多少的个数,为避免负数下标情况,将数组大小设置为n*2 + 1
        int[] cnt = new int[n * 2 + 1];
        // 下标为index的情况直接添加
        cnt[n] = 1;
        // index向后遍历, c初始值为n避免出现负数的情况,以n代表0,n+1代表1
        for (int i = index + 1, c = n; i < n; i++) {
            c += nums[i] > k ? 1 : -1;
            // 记录每种情况的个数
            cnt[c]++;
        }
        // 为1或0时符合题目要求,k为中位数
        int ans = cnt[n] + cnt[n + 1];
        for (int i = index - 1, c = n; i >= 0; i--) {
            // 此时c与上面的c相反, 此处很妙
            c += nums[i] > k ? -1 : 1;
            // cnt中的c与当前c和为 0 或 1 的 加到ans中
            ans += cnt[c] + cnt[c + 1];
        }
        return ans;
    }

    public int countSubarrays20(int[] nums, int k) {
        int ans = 0, index = 0;
        //大于k的前缀和
        int[] prefix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                index = i;
            }
            int temp = nums[i] > k ? 1 : 0;
            prefix[i] = i == 0 ? temp : prefix[i - 1] + temp;
        }

        for (int i = index; i >= 0; i--) {
            for (int j = index; j < nums.length; j++) {
                int bigNum = prefix[j] - prefix[i] + (nums[i] > k ? 1 : 0);
                int size = j - i + 1;
                if (size == 1 || size == 2 * bigNum || size == (2 * bigNum + 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
