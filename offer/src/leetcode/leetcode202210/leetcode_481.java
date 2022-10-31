package leetcode.leetcode202210;

public class leetcode_481 {
    public int magicalString02(int n) {
        char[] s = new char[n + 2];
        s[0] = 1; s[1] = s[2] = 2;
        char c = 2;
        for (int i = 2, j = 3; j < n; ++i) {
            c ^= 3; // 1^3=2, 2^3=1，这样就能在 1 和 2 之间转换
            s[j++] = c;
            if (s[i] == 2) s[j++] = c;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) ans += 2 - s[i]; // 2-1=1，2-2=0，这样就只统计了 1
        return ans;
    }
}
