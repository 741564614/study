package leetcode.leetcode202212;

public class leetcode_1759 {
    public int countHomogenous(String s) {
        long mod = (long) (1e9 + 7);
        int l = 0, r = 0;
        long ans = 0;
        while (l < s.length()) {
            char a = s.charAt(l);
            while (r < s.length() && s.charAt(r) == a) {
                r++;
            }
            ans = (ans+count(r - l) ) % mod;
            l = r;
        }
        return (int) (ans%mod);
    }

    public long count(int length) {
        long l = length;
        return (l * (l + 1)) / 2;
    }
}
