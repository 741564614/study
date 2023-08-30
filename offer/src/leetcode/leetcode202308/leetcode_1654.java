package leetcode.leetcode202308;

import java.util.*;

public class leetcode_1654 {

    public static void main(String[] args) {
        int[] f = new int[]{1998};
        System.out.println(new leetcode_1654().minimumJumps(f, 1999, 2000, 2000));
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        boolean[][] check = new boolean[10000 + a][2];
        check[0][0] = check[0][1] = true;
        for (int i : forbidden) {
            check[i][0] = check[i][1] = true;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == x) {
                    return ans;
                }
                int nextA = poll[0] + a, nextB = poll[0] - b;
                if (nextA < check.length && !check[nextA][0]) {
                    queue.offer(new int[]{nextA, 0});
                    check[nextA][0] = true;
                }
                if (poll[1] == 0 && nextB >= 0 && !check[nextB][1]) {
                    queue.offer(new int[]{nextB, 1});
                    check[nextB][1] = true;
                }
            }
            ans++;
        }
        return -1;
    }

    class Solution {
        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            Queue<int[]> queue = new ArrayDeque<int[]>();
            Set<Integer> visited = new HashSet<Integer>();
            queue.offer(new int[]{0, 1, 0});
            visited.add(0);
            int lower = 0, upper = Math.max(Arrays.stream(forbidden).max().getAsInt() + a, x) + b;
            Set<Integer> forbiddenSet = new HashSet<Integer>();
            for (int position : forbidden) {
                forbiddenSet.add(position);
            }
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int position = arr[0], direction = arr[1], step = arr[2];
                if (position == x) {
                    return step;
                }
                int nextPosition = position + a;
                int nextDirection = 1;
                if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                    visited.add(nextPosition * nextDirection);
                    queue.offer(new int[]{nextPosition, nextDirection, step + 1});
                }
                if (direction == 1) {
                    nextPosition = position - b;
                    nextDirection = -1;
                    if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                        visited.add(nextPosition * nextDirection);
                        queue.offer(new int[]{nextPosition, nextDirection, step + 1});
                    }
                }
            }
            return -1;
        }
    }

}
