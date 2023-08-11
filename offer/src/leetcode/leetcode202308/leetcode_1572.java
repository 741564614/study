package leetcode.leetcode202308;

public class leetcode_1572 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans = 0;
        for (int i = 0, j = 0, k = n - 1; i < n && j < n && k >= 0; i++, j++, k--) {
            ans += mat[i][j];
            ans += mat[i][k];
        }
        if (n % 2 != 0) {
            ans -= mat[n / 2][n / 2];
        }
        return ans;
    }
}
