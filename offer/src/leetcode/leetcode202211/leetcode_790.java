package leetcode.leetcode202211;

public class leetcode_790 {
    private static final long MOD = (long) 1e9 + 7;

    public int numTilings02(int n) {
        if (n == 1) return 1;
        long[] f = new long[n + 1];
        f[0] = f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; ++i)
            f[i] = (f[i - 1] * 2 + f[i - 3]) % MOD;
        return (int) f[n];
    }
}
