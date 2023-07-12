package leetcode.leetcode202307;

public class leetcode_2544 {
    public int alternateDigitSum(int n) {
        int num = n, len = 0;
        while (num > 0) {
            num /= 10;
            len++;
        }
        int m = len % 2 == 0 ? -1 : 1, ans = 0;
        while (n > 0) {
            ans += (n % 10 * m);
            n /= 10;
            m *= -1;
        }
        return ans;
    }
}
