package leetcode.leetcode202211;

public class leetcode_878 {
    public static void main(String[] args) {
        System.out.println(new leetcode_878().nthMagicalNumber02(10000, 2, 3));
    }

    static final int MOD = 1000000007;

    public int nthMagicalNumber02(int n, int a, int b) {
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        int c = lcm(a, b);
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

}
