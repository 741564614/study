package leetcode.leetcode202304;

public class leetcode_2427 {
    public int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int ans = 1;
        for (int i = 2; i < min; i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            }
        }
        return ans;
    }

    class Solution {
        public int commonFactors(int a, int b) {
            int c = gcd(a, b), ans = 0;
            for (int x = 1; x * x <= c; ++x) {
                if (c % x == 0) {
                    ++ans;
                    if (x * x != c) {
                        ++ans;
                    }
                }
            }
            return ans;
        }

        public int gcd(int a, int b) {
            while (b != 0) {
                a %= b;
                a ^= b;
                b ^= a;
                a ^= b;
            }
            return a;
        }
    }


}
