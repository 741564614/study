package leetcode.leetcode202303;

public class leetcode_1599 {

    public static void main(String[] args) {
        int[] customers = new int[]{8, 3};
        System.out.println(new leetcode_1599().minOperationsMaxProfit(customers, 5, 6));
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit = 0, minRun = -1;
        int customer = 0, nowProfit = 0, nowRun = 0;
        for (int customerNum : customers) {
            customer += customerNum;
            nowProfit += (Math.min(4, customer) * boardingCost - runningCost);
            nowRun++;
            customer = Math.max(customer - 4, 0);
            if (nowProfit > maxProfit) {
                minRun = nowRun;
                maxProfit = nowProfit;
            }
        }

        if (customer > 0) {
            int full = customer / 4, remainder = customer % 4;
            nowProfit += full * (4 * boardingCost - runningCost);
            if (remainder * boardingCost > runningCost) {
                nowProfit += (remainder * boardingCost - runningCost);
                nowRun++;
            }
            if (nowProfit > maxProfit) {
                minRun = nowRun + full;
            }
        }
        return minRun;
    }
}
