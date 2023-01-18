package leetcode.leetcode202301;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1814 {
    long mod = (long) (1e9 + 7);

    public int countNicePairs02(int[] nums) {
        final int MOD = 1000000007;
        int res = 0;
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i : nums) {
            int temp = i, j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            res = (res + h.getOrDefault(i - j, 0)) % MOD;
            h.put(i - j, h.getOrDefault(i - j, 0) + 1);
        }
        return res;
    }

    public int countNicePairs(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (int num : nums) {
            long key = num - reverse(num);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long ans = 0;
        for (Integer v : map.values()) {
            if (v >= 2) {
                ans = (ans + countC(v)) % mod;
            }
        }
        return (int) (ans % mod);
    }

    public long countC(int a) {
        return ((long) a * (long) (a - 1)) / 2L;
    }


    public long reverse(int a) {
        long ans = 0;
        while (a > 0) {
            ans = ans * 10 + (a % 10);
            a /= 10;
        }
        return ans;
    }
}
