package leetcode.leetcode202209;

import java.util.HashSet;
import java.util.Set;

public class leetcode_827 {
    public static void main(String[] args) {

    }

    int N = 510;
    int[] p = new int[N * N], size = new int[N * N];
    int[][] moves = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) {
            p[pa] = pb;
            size[pb] += size[pa];
        }
    }


    public int largestIsland(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n * n; i++) {
            p[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    for (int[] move : moves) {
                        int x = i + move[0], y = j + move[1];
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) {
                            continue;
                        }
                        union(i * n + j, x * n + y);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> rootSet = new HashSet<>();
                    int tol = 1;
                    for (int[] move : moves) {
                        int x = i + move[0], y = j + move[1];
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) {
                            continue;
                        }
                        int root = find(x * n + y);
                        if (!rootSet.contains(root)) {
                            tol += size[root];
                            rootSet.add(root);
                        }
                    }
                    ans = Math.max(ans, tol);
                } else {
                    ans = Math.max(ans, size[find(i * n + j)]);
                }
            }
        }
        return ans;
    }
}
