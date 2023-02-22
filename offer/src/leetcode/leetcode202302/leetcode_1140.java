package leetcode.leetcode202302;

public class leetcode_1140 {
    public int stoneGameII(int[] piles) {
        int n = piles.length, sum = 0;
        int[][] dp = new int[n][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sum += piles[i];
            //以i为开始，以M从1开始进行游戏，M最大开始数为数组长度
            for (int M = 1; M <= n; M++) {
                //剩下能直接拿完
                if (i + 2 * M >= n) {
                    dp[i][M] = sum;
                } else {
                    //不能一次拿完的，就让后面的人少拿
                    for (int x = 1; x <= 2 * M; x++) {
                        //状态转移，让后面的人从i+x开始拿
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
