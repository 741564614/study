package leetcode.leetcode202210;

public class leetcode_940 {
    public int distinctSubseqII02(String s) {
        int mod = (int) 1e9 + 7;
        int[] f = new int[26];
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int prev = f[c];
            f[c] = (total + 1) % mod;
            total = (total + f[c]) % mod;
            total = (total - prev + mod) % mod;
        }
        return total;
    }
}
