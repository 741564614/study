package offer;

import java.util.Arrays;

public class offer_60 {
    public double[] dicesProbability02(int n) {
        double[][] f = new double[n + 1][6 * n + 1];
        double base = 1 / 6.0;
        for (int i = 1; i <= 6; i++) {
            f[1][i] = base;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = i; j < 6 * n + 1; j++) {
                for (int k = 1; k <= Math.min(6, j - 1); k++) {
                    f[i][j] += f[i - 1][j - k] * base;
                }
            }
        }
        return Arrays.copyOfRange(f[n], n, 6 * n + 1);
    }

    public double[] dicesProbability03(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        double[] d = new double[]{0.00077, 0.00309, 0.00772, 0.01543, 0.02701, 0.04321, 0.06173, 0.08025, 0.09645, 0.10802, 0.11265, 0.10802, 0.09645, 0.08025, 0.06173, 0.04321, 0.02701, 0.01543, 0.00772, 0.00309, 0.00077};
        double base = d[0];
        for (double v : d) {
            System.out.println(v / base);
        }
    }
}
