package leetcode.leetcode202306;

import java.util.*;

public class leetcode_1659 {
    static class Solution {
        static final int T = 243, N = 5, M = 6;
        int n, m, tot;
        int[][] maskBits;
        int[] ivCount;
        int[] evCount;
        int[] innerScore;
        int[][] interScore;
        int[][][][] d;
        // 邻居间的分数
        static int[][] score = {
                {0, 0, 0},
                {0, -60, -10},
                {0, -10, 40}
        };

        public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
            this.n = n;
            this.m = m;
            // 状态总数为 3^n
            this.tot = (int) Math.pow(3, n);
            this.maskBits = new int[T][N];
            this.ivCount = new int[T];
            this.evCount = new int[T];
            this.innerScore = new int[T];
            this.interScore = new int[T][T];
            this.d = new int[N][T][M + 1][M + 1];

            initData();
            // 记忆化搜索数组，初始化为 -1，表示未赋值
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    for (int k = 0; k <= M; k++) {
                        Arrays.fill(d[i][j][k], -1);
                    }
                }
            }
            return dfs(0, 0, introvertsCount, extrovertsCount);
        }

        public void initData() {
            // 计算行内分数
            for (int mask = 0; mask < tot; mask++) {
                int maskTmp = mask;
                for (int i = 0; i < n; i++) {
                    int x = maskTmp % 3;
                    maskBits[mask][i] = x;
                    maskTmp /= 3;
                    if (x == 1) {
                        ivCount[mask]++;
                        innerScore[mask] += 120;
                    } else if (x == 2) {
                        evCount[mask]++;
                        innerScore[mask] += 40;
                    }
                    if (i > 0) {
                        innerScore[mask] += score[x][maskBits[mask][i - 1]];
                    }
                }
            }
            // 计算行间分数
            for (int i = 0; i < tot; i++) {
                for (int j = 0; j < tot; j++) {
                    interScore[i][j] = 0;
                    for (int k = 0; k < n; k++) {
                        interScore[i][j] += score[maskBits[i][k]][maskBits[j][k]];
                    }
                }
            }
        }

        public int dfs(int row, int premask, int iv, int ev) {
            if (row == m || (iv == 0 && ev == 0)) {
                return 0;
            }
            // 如果该状态已经计算过答案，则直接返回
            if (d[row][premask][iv][ev] != -1) {
                return d[row][premask][iv][ev];
            }
            // 合法状态，初始值为 0
            int res = 0;
            for (int mask = 0; mask < tot; mask++) {
                // mask 包含的内向人数不能超过 iv ，外向人数不能超过 ev
                if (ivCount[mask] > iv || evCount[mask] > ev) {
                    continue;
                }
                res = Math.max(res, dfs(row + 1, mask, iv - ivCount[mask], ev - evCount[mask])
                        + innerScore[mask]
                        + interScore[premask][mask]);
            }
            d[row][premask][iv][ev] = res;
            return res;
        }
    }

    static class Solution02 {
        static final int T = 243, N = 5, M = 6;
        int n, m, tot;
        int[] p;
        int[][][][] d;
        // 邻居间的分数
        static int[][] score = {
                {0, 0, 0},
                {0, -60, -10},
                {0, -10, 40}
        };

        public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
            this.n = n;
            this.m = m;
            // 状态总数为 3^n
            this.tot = (int) Math.pow(3, n);
            this.p = new int[N];
            p[0] = 1;
            for (int i = 1; i < n; i++) {
                p[i] = p[i - 1] * 3;
            }
            this.d = new int[N * N][T][M + 1][M + 1];

            // 记忆化搜索数组，初始化为 -1，表示未赋值
            for (int i = 0; i < N * N; i++) {
                for (int j = 0; j < T; j++) {
                    for (int k = 0; k <= M; k++) {
                        Arrays.fill(d[i][j][k], -1);
                    }
                }
            }
            return dfs(0, 0, introvertsCount, extrovertsCount);
        }

        public int dfs(int pos, int mask, int iv, int ev) {
            if (pos == n * m || (iv == 0 && ev == 0)) {
                return 0;
            }
            int res = d[pos][mask][iv][ev];
            if (res != -1) {
                return res;
            }
            res = 0;
            int up = mask / p[n - 1], left = mask % 3;
            // 若处于第一列，则左侧没有元素，将 left 置为 0
            if (pos % n == 0) {
                left = 0;
            }
            for (int i = 0; i < 3; i++) {
                if ((i == 1 && iv == 0) || (i == 2 && ev == 0)) {
                    continue;
                }
                int nextMask = mask % p[n - 1] * 3 + i;
                int scoreSum = dfs(pos + 1, nextMask, iv - (i == 1 ? 1 : 0), ev - (i == 2 ? 1 : 0))
                        + score[up][i]
                        + score[left][i];
                if (i == 1) {
                    scoreSum += 120;
                } else if (i == 2) {
                    scoreSum += 40;
                }
                res = Math.max(res, scoreSum);
            }
            d[pos][mask][iv][ev] = res;
            return res;
        }
    }

}
