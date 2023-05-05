package leetcode.leetcode202305;

public class leetcode_2432 {
    public int hardestWorker(int n, int[][] logs) {
        int max = 0, ans = n - 1, prev = 0;
        for (int i = 0; i < logs.length; i++) {
            int len = logs[i][1] - prev;
            if (len > max) {
                max = len;
                ans = logs[i][0];
            } else if (len == max && logs[i][0] < ans) {
                ans = logs[i][0];
            }
            prev = logs[i][1];
        }
        return ans;
    }
}
