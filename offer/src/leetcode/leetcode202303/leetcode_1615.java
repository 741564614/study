package leetcode.leetcode202303;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] matrix = new int[n][n];
        List<Integer>[] art = new List[n];
        for (int i = 0; i < art.length; i++) {
            art[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            matrix[road[0]][road[1]] = 1;
            matrix[road[1]][road[0]] = 1;
            art[road[0]].add(road[1]);
            art[road[1]].add(road[0]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ans = art[i].size() + art[j].size();
                if (matrix[i][j] == 1 || matrix[j][i] == 1) {
                    ans--;
                }
                max = Math.max(max, ans);
            }
        }
        return max;
    }

    public int maximalNetworkRank02(int n, int[][] roads) {
        int[] degree = new int[n];
        int[][] flags = new int[n][n];
        for (int[] r : roads) {
            flags[r[0]][r[1]] = 1;
            flags[r[1]][r[0]] = 1;
            ++degree[r[0]];
            ++degree[r[1]];
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                int num = degree[i] + degree[j] - flags[i][j];
                ans = Math.max(ans, num);
            }
        return ans;
    }

    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            boolean[][] connect = new boolean[n][n];
            int[] degree = new int[n];
            for (int[] road : roads) {
                int x = road[0], y = road[1];
                connect[x][y] = true;
                connect[y][x] = true;
                degree[x]++;
                degree[y]++;
            }

            int first = -1, second = -2;
            List<Integer> firstArr = new ArrayList<Integer>();
            List<Integer> secondArr = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) {
                if (degree[i] > first) {
                    second = first;
                    secondArr = new ArrayList<Integer>(firstArr);
                    first = degree[i];
                    firstArr.clear();
                    firstArr.add(i);
                } else if (degree[i] == first) {
                    firstArr.add(i);
                } else if (degree[i] > second){
                    secondArr.clear();
                    second = degree[i];
                    secondArr.add(i);
                } else if (degree[i] == second) {
                    secondArr.add(i);
                }
            }
            if (firstArr.size() == 1) {
                int u = firstArr.get(0);
                for (int v : secondArr) {
                    if (!connect[u][v]) {
                        return first + second;
                    }
                }
                return first + second - 1;
            } else {
                int m = roads.length;
                if (firstArr.size() * (firstArr.size() - 1) / 2 > m) {
                    return first * 2;
                }
                for (int u : firstArr) {
                    for (int v : firstArr) {
                        if (u != v && !connect[u][v]) {
                            return first * 2;
                        }
                    }
                }
                return first * 2 - 1;
            }
        }
    }

}
