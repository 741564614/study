package leetcode.leetcode202301;

public class leetcode_1802 {
    public int maxValue(int n, int index, int maxSum) {
        long l = 0, r = maxSum+1;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long q = index + mid - 1;
            long p = index - mid + 1;
            long qNum = q <= (n - 1) ? (n - 1 - q) : (-1 * (q - n + 1) * (q - n + 2) / 2);
            long pNum = p >= 0 ? p : (-1 * p * (p - 1) / 2);
            long sum = mid * mid + qNum + pNum;
            if (sum > maxSum) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) (l-1);
    }
}
