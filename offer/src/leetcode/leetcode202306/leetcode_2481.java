package leetcode.leetcode202306;

public class leetcode_2481 {
    public int numberOfCuts(int n) {
        if (n == 2 || n == 4) {
            return n / 2;
        }
        if (n == 1) {
            return 0;
        }
        return n % 2 == 0 ? n / 2 : n;
    }
}
