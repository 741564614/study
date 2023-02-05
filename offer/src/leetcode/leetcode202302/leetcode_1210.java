package leetcode.leetcode202302;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1210 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(new leetcode_1210().minimumMoves(grid));
    }


    int ans;
    int[][][] dfsVisited;

    public int minimumMoves(int[][] grid) {
        ans = Integer.MAX_VALUE;
        dfsVisited = new int[grid.length][grid[0].length][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Arrays.fill(dfsVisited[i][j], Integer.MAX_VALUE);
            }
        }
        dfs(grid, 0, 0, 0, 1, 0, true);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void dfs(int[][] grid, int x1, int y1, int x2, int y2, int step, boolean canS) {
        if (x1 == grid.length - 1 && x2 == grid.length - 1 && y1 == grid[0].length - 2 && y2 == grid[0].length - 1) {
            ans = Math.min(ans, step);
            return;
        }

        boolean downOverIndex = (x1 + 1 < grid.length && x2 + 1 < grid.length);

        boolean rightOverIndex = (y1 + 1 < grid[0].length && y2 + 1 < grid[0].length);

        //向右
        if (rightOverIndex && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0 && dfsVisited[x1][y1 + 1][x1 == x2 ? 0 : 1] > step) {
            dfsVisited[x1][y1 + 1][x1 == x2 ? 0 : 1] = step;
            dfs(grid, x1, y1 + 1, x2, y2 + 1, step + 1, true);
        }
        //向下
        if (downOverIndex && grid[x1 + 1][y1] == 0 && grid[x2 + 1][y2] == 0 && dfsVisited[x1 + 1][y1][x1 == x2 ? 0 : 1] > step) {
            dfsVisited[x1 + 1][y1][x1 == x2 ? 0 : 1] = step;
            dfs(grid, x1 + 1, y1, x2 + 1, y2, step + 1, true);
        }
        //旋转
        if (canS) {
            //水平转垂直
            if (x1 == x2 && downOverIndex && grid[x1 + 1][y1] == 0 && grid[x2 + 1][y2] == 0 && dfsVisited[x1][y1][1] > step) {
                dfsVisited[x1][y1][1] = step;
                dfs(grid, x1, y1, x1 + 1, y1, step + 1, false);
            }
            //垂直转水平
            if (y1 == y2 && rightOverIndex && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0 && dfsVisited[x1][y1][0] > step) {
                dfsVisited[x1][y1][0] = step;
                dfs(grid, x1, y1, x1, y1 + 1, step + 1, false);
            }
        }
    }


    public int minimumMoves20(int[][] grid) {
        Queue<Pair<int[][], Boolean>> queue = new LinkedList<>();
        queue.offer(new Pair<>(new int[][]{{0, 0}, {0, 1}}, true));
        boolean[][][] visited = new boolean[grid.length][grid[0].length][2];
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<int[][], Boolean> pair = queue.poll();
                int x1 = pair.getKey()[0][0], y1 = pair.getKey()[0][1], x2 = pair.getKey()[1][0], y2 = pair.getKey()[1][1];
                boolean canS = pair.getValue();
                if (x1 == grid.length - 1 && x2 == grid.length - 1 && y1 == grid[0].length - 2 && y2 == grid[0].length - 1) {
                    return step;
                }

                boolean downOverIndex = (x1 + 1 < grid.length && x2 + 1 < grid.length);

                boolean rightOverIndex = (y1 + 1 < grid[0].length && y2 + 1 < grid[0].length);

                //向右
                if (rightOverIndex && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0 && !visited[x1][y1 + 1][x1 == x2 ? 0 : 1]) {
                    visited[x1][y1 + 1][x1 == x2 ? 0 : 1] = true;
                    queue.offer(new Pair<>(new int[][]{{x1, y1 + 1}, {x2, y2 + 1}}, true));
                }
                //向下
                if (downOverIndex && grid[x1 + 1][y1] == 0 && grid[x2 + 1][y2] == 0 && !visited[x1 + 1][y1][x1 == x2 ? 0 : 1]) {
                    visited[x1 + 1][y1][x1 == x2 ? 0 : 1] = true;
                    queue.offer(new Pair<>(new int[][]{{x1 + 1, y1}, {x2 + 1, y2}}, true));
                }
                //旋转
                if (canS) {
                    //水平转垂直
                    if (x1 == x2 && downOverIndex && grid[x1 + 1][y1] == 0 && grid[x2 + 1][y2] == 0 && !visited[x1][y1][1]) {
                        visited[x1][y1][1] = true;
                        queue.offer(new Pair<>(new int[][]{{x1, y1}, {x1 + 1, y1}}, false));
                    }
                    //垂直转水平
                    if (y1 == y2 && rightOverIndex && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0 && !visited[x1][y1][0]) {
                        visited[x1][y1][0] = true;
                        queue.offer(new Pair<>(new int[][]{{x1, y1}, {x1, y1 + 1}}, false));
                    }
                }
            }
            step++;

        }
        return -1;
    }


    public int minimumMoves02(int[][] grid) {
        int n = grid.length;
        int[][][] dist = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        dist[0][0][0] = 0;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1], status = arr[2];
            if (status == 0) {
                // 向右移动一个单元格
                if (y + 2 < n && dist[x][y + 1][0] == -1 && grid[x][y + 2] == 0) {
                    dist[x][y + 1][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y + 1, 0});
                }
                // 向下移动一个单元格
                if (x + 1 < n && dist[x + 1][y][0] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x + 1][y][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x + 1, y, 0});
                }
                // 顺时针旋转 90 度
                if (x + 1 < n && y + 1 < n && dist[x][y][1] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][1] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y, 1});
                }
            } else {
                // 向右移动一个单元格
                if (y + 1 < n && dist[x][y + 1][1] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y + 1][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y + 1, 1});
                }
                // 向下移动一个单元格
                if (x + 2 < n && dist[x + 1][y][1] == -1 && grid[x + 2][y] == 0) {
                    dist[x + 1][y][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x + 1, y, 1});
                }
                // 逆时针旋转 90 度
                if (x + 1 < n && y + 1 < n && dist[x][y][0] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][0] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y, 0});
                }
            }
        }

        return dist[n - 1][n - 2][0];
    }
}
