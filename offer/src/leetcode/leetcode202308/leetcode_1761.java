package leetcode.leetcode202308;

import java.util.*;

public class leetcode_1761 {
    public int minTrioDegree(int n, int[][] edges) {
        int[] dg = new int[n];
        Set<Integer>[] ans = new HashSet[n];
        for (int i = 0; i < n; i++) {
            ans[i]=new HashSet<>();
        }
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            dg[x]++;
            dg[y]++;
            ans[x].add(y);
            ans[y].add(x);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (ans[i].contains(j) && ans[j].contains(k) && ans[i].contains(k)) {
                        min = Math.min(min, dg[i] + dg[j] + dg[k] - 6);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    class Solution {
        public int minTrioDegree(int n, int[][] edges) {
            int[][] g = new int[n][n];
            int[] degree = new int[n];

            for (int[] edge : edges) {
                int x = edge[0] - 1, y = edge[1] - 1;
                g[x][y] = g[y][x] = 1;
                ++degree[x];
                ++degree[y];
            }

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (g[i][j] == 1) {
                        for (int k = j + 1; k < n; ++k) {
                            if (g[i][k] == 1 && g[j][k] == 1) {
                                ans = Math.min(ans, degree[i] + degree[j] + degree[k] - 6);
                            }
                        }
                    }
                }
            }

            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

}
