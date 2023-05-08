package leetcode.leetcode202305;

import java.util.*;

public class leetcode_1263 {
    public int minPushBox02(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sx = 0, sy = 0, bx = 0, by = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        int[] move = new int[]{0, -1, 0, 1, 0};
        boolean[][] visited = new boolean[m * n][m * n];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{sx * n + sy, bx * n + by, 0});
        visited[sx * n + sy][bx * n + by] = true;
        while (!deque.isEmpty()) {
            int[] ints = deque.pollFirst();
            int sx1 = ints[0] / n, sy1 = ints[0] % n, bx1 = ints[1] / n, by1 = ints[1] % n, d = ints[2];
            if (grid[bx1][by1] == 'T') {
                return d;
            }
            for (int i = 0; i < 4; i++) {
                int sx2 = sx1 + move[i], sy2 = sy1 + move[i + 1], sm = sx2 * n + sy2;
                if (!check(grid, sx2, sy2)) {
                    continue;
                }
                if (sx2 == bx1 && sy2 == by1) {
                    int bx2 = bx1 + move[i], by2 = by1 + move[i + 1], bm = bx2 * n + by2;
                    if (check(grid, bx2, by2) && !visited[sm][bm]) {
                        deque.offerLast(new int[]{sm, bm, d + 1});
                        visited[sm][bm] = true;
                    }
                } else if (!visited[sm][ints[1]]) {
                    deque.offerFirst(new int[]{sm, ints[1], d});
                    visited[sm][ints[1]] = true;
                }
            }

        }
        return -1;
    }

    public boolean check(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != '#';
    }
}
