package leetcode.leetcode202303;

public class leetcode_1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int i = 0, j = 0;
        int[][] ans = new int[rowSum.length][colSum.length];
        while (i < rowSum.length && j < colSum.length) {
            if (rowSum[i] < colSum[j]) {
                ans[i][j] = rowSum[i];
                colSum[j] -= rowSum[i];
                i++;
            } else if (colSum[j] < rowSum[i]) {
                ans[i][j] = colSum[j];
                rowSum[i] -= colSum[j];
                j++;
            } else {
                ans[i][j] = rowSum[i];
                rowSum[i] = 0;
                colSum[j] = 0;
                i++;
                j++;
            }
        }
        return ans;
    }
}
