package leetcode.leetcode202211;

import java.util.Arrays;

public class leetcode_764 {

    public static void main(String[] args) {
        System.out.println(new leetcode_764().orderOfLargestPlusSign(3, new int[][]{{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}}));
    }

    /**
     * 前缀和
     * @param n
     * @param mines
     * @return
     */
    public int orderOfLargestPlusSign02(int n, int[][] mines) {
        int[][] g = new int[n + 10][n + 10];
        for (int i = 1; i <= n; i++) Arrays.fill(g[i], 1);
        for (int[] info : mines) g[info[0] + 1][info[1] + 1] = 0;
        int[][] a = new int[n + 10][n + 10], b = new int[n + 10][n + 10], c = new int[n + 10][n + 10], d = new int[n + 10][n + 10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j] == 1) {
                    a[i][j] = a[i - 1][j] + 1;
                    b[i][j] = b[i][j - 1] + 1;
                }
                if (g[n + 1 - i][n + 1 - j] == 1) {
                    c[n + 1 - i][n + 1 - j] = c[n + 2 - i][n + 1 - j] + 1;
                    d[n + 1 - i][n + 1 - j] = d[n + 1 - i][n + 2 - j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, Math.min(Math.min(a[i][j], b[i][j]), Math.min(c[i][j], d[i][j])));
            }
        }
        return ans;
    }

    int _n;
    boolean[][] check;

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (n < 3) {
            return mines.length==n*n?0:1;
        }
        _n = n;
        check = new boolean[n][n];
        for (int[] mine : mines) {
            check[mine[0]][mine[1]] = true;
        }
        int[][] move = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int max = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if (!check[i][j]) {
                    int[][] point = new int[4][2];
                    for (int p = 0; p < point.length; p++) {
                        point[p] = new int[]{i, j};
                    }
                    int ans = 1;
                    while (movePoints(point, move)) {
                        ans++;
                    }
                    max = Math.max(max, ans);
                }
            }
        }
        return max;
    }

    public boolean movePoints(int[][] point, int[][] move) {
        boolean ans = true;
        for (int i = 0; i < point.length; i++) {
            ans &= movePoint(point[i], move[i]);
        }
        return ans;
    }

    public boolean movePoint(int[] point, int[] move) {
        point[0] += move[0];
        point[1] += move[1];
        int x = point[0], y = point[1];
        return x >= 0 && x < _n && y >= 0 && y < _n && !check[x][y];
    }
}
