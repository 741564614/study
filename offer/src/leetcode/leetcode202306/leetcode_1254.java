package leetcode.leetcode202306;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1254 {
    public int closedIsland(int[][] grid) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 1;
                    boolean close = true;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int cx = poll[0], cy = poll[1];
                        if (cx == 0 || cy == 0 || cx == m - 1 || cy == n - 1) {
                            close = false;
                        }
                        for (int k = 0; k < dir.length; k++) {
                            int nx = cx + dir[k][0], ny = cy + dir[k][1];
                            if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 0) {
                                grid[nx][ny] = 1;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    if (close) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
