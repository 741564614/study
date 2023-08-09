package leetcode.leetcode202308;

public class leetcode_1281 {
    public int subtractProductAndSum(int n) {
        long sum = 0, product = 1;
        while (n > 0) {
            int k = n % 10;
            sum += k;
            product *= k;
            n /= 10;
        }
        return (int) (product - sum);
    }
}
