package leetcode.leetcode202305;

import java.util.LinkedList;

public class leetcode_1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] move = new int[][]{{1, 1}, {1, 0}, {0, 1}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        boolean[][] check = new boolean[n][n];
        LinkedList<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 0) {
            queue.offer(new int[]{0, 0});
            check[0][0] = true;
        }
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == n - 1 && poll[1] == n - 1 && grid[n - 1][n - 1] == 0) {
                    return ans;
                }
                for (int[] m : move) {
                    int x = poll[0] + m[0];
                    int y = poll[1] + m[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && !check[x][y] && grid[x][y] == 0) {
                        check[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
