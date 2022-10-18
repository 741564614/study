package leetcode.leetcode202210;

import java.util.ArrayList;
import java.util.List;

public class leetcode_902 {
    int[] nums;
    int dp(int x) {
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        int n = list.size(), m = nums.length, ans = 0;
        // 位数和 x 相同
        for (int i = n - 1, p = 1; i >= 0; i--, p++) {
            int cur = list.get(i);
            int l = 0, r = m - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (nums[mid] <= cur) l = mid;
                else r = mid - 1;
            }
            if (nums[r] > cur) {
                break;
            } else if (nums[r] == cur) {
                ans += r * (int) Math.pow(m, (n - p));
                if (i == 0) ans++;
            } else if (nums[r] < cur) {
                ans += (r + 1) * (int) Math.pow(m, (n - p));
                break;
            }
        }
        // 位数比 x 少的
        for (int i = 1, last = 1; i < n; i++) {
            int cur = last * m;
            ans += cur; last = cur;
        }
        return ans;
    }
    public int atMostNGivenDigitSet02(String[] digits, int max) {
        int n = digits.length;
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(digits[i]);
        return dp(max);
    }
}
