package leetcode.leetcode202308;

import java.util.*;

public class leetcode_980 {

    public static void main(String[] args) {
        int[][] g = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(new leetcode_980().uniquePathsIII(g));
    }


    int[][] move = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int uniquePathsIII(int[][] grid) {
        boolean[][] check = new boolean[grid.length][grid[0].length];
        int endLen = 0, x = 0, y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    check[x][y] = true;
                }
                if (grid[i][j] != -1) {
                    endLen++;
                }
            }
        }
        Set<String> ans = new HashSet<>();
        dfs(grid, check, x, y, new StringBuilder(), ans);
        int finalEndLen = endLen - 1;
        return (int) ans.stream().filter(a -> a.length() == finalEndLen).count();
    }

    public void dfs(int[][] grid, boolean[][] check, int x, int y, StringBuilder sb, Set<String> ans) {
        if (grid[x][y] == 2) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < move.length; i++) {
            int nx = x + move[i][0], ny = y + move[i][1];
            if (nx < grid.length && nx >= 0 && ny < grid[0].length && ny >= 0 && !check[nx][ny] && grid[nx][ny] != -1) {
                check[nx][ny] = true;
                sb.append(i);
                dfs(grid, check, nx, ny, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
                check[nx][ny] = false;
            }
        }
    }

    class Solution {
        public int uniquePathsIII(int[][] grid) {
            int cnt0 = 0, sx = -1, sy = -1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0) cnt0++;
                    else if (grid[i][j] == 1) { // 起点
                        sx = i;
                        sy = j;
                    }
                }
            }
            return dfs(grid, sx, sy, cnt0 + 1); // +1 把起点也算上
        }

        private int dfs(int[][] grid, int x, int y, int left) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] < 0)
                return 0; // 不合法
            if (grid[x][y] == 2) // 到达终点
                return left == 0 ? 1 : 0; // 必须访问所有的无障碍方格
            grid[x][y] = -1; // 标记成访问过，因为题目要求「不能重复通过同一个方格」
            int ans = dfs(grid, x - 1, y, left - 1) + dfs(grid, x, y - 1, left - 1) +
                    dfs(grid, x + 1, y, left - 1) + dfs(grid, x, y + 1, left - 1);
            grid[x][y] = 0; // 恢复现场
            return ans;
        }
    }
}
