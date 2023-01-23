package leetcode.leetcode202301;

public class leetcode_2303 {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        int prev = 0;
        for (int[] bracket : brackets) {
            int next = Math.min(bracket[0], income);
            ans += (next - prev) * (bracket[1] / 100D);
            prev = next;
            if (next == income) {
                break;
            }
        }
        return ans;
    }
}
