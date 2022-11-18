package leetcode.leetcode202211;

import java.util.Arrays;

public class leetcode_891 {
    public static void main(String[] args) {
        System.out.println(new leetcode_891().sumSubseqWidths02(new int[]{96,87,191,197,40,101,108,35,169,50,168,182,95,80,144,43,18,60,174,13,77,173,38,46,80,117,13,19,11,6,13,118,39,80,171,36,86,156,165,190,53,49,160,192,57,42,97,35,124,200,84,70,145,180,54,141,159,42,66,66,25,95,24,136,140,159,71,131,5,140,115,76,151,137,63,47,69,164,60,172,153,183,6,70,40,168,133,45,116,188,20,52,70,156,44,27,124,59,42,172}));
    }

    static int N = 100010, MOD = (int)1e9+7;
    static long[] p = new long[N];
    static {
        p[0] = 1;
        for (int i = 1; i < N; i++) p[i] = p[i - 1] * 2 % MOD;
    }
    public int sumSubseqWidths02(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            ans += (p[i] * nums[i]) % MOD;
            ans %= MOD;
            ans -= (p[n - i - 1] * nums[i]) % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }


}
