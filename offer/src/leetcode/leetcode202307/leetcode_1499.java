package leetcode.leetcode202307;

import java.util.*;
import java.util.PriorityQueue;

public class leetcode_1499 {
    public int findMaxValueOfEquation02(int[][] points, int k) {
        int ans = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{points[0][0] - points[0][1], points[0][0]});
        for (int i = 1; i < points.length; i++) {
            while (!pq.isEmpty() && (points[i][0] - pq.peek()[1] > k)) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans = Math.max(ans, pq.peek()[0] + points[i][0] + points[i][1]);
            }
            pq.offer(new int[]{points[i][0] - points[i][1], points[i][0]});
        }
        return ans;
    }

    class Solution {
        public int findMaxValueOfEquation(int[][] points, int k) {
            int res = Integer.MIN_VALUE;
            Deque<int[]> queue = new ArrayDeque<int[]>();
            for (int[] point : points) {
                int x = point[0], y = point[1];
                while (!queue.isEmpty() && x - queue.peekFirst()[1] > k) {
                    queue.pollFirst();
                }
                if (!queue.isEmpty()) {
                    res = Math.max(res, x + y + queue.peekFirst()[0]);
                }
                while (!queue.isEmpty() && y - x >= queue.peekLast()[0]) {
                    queue.pollLast();
                }
                queue.offer(new int[]{y - x, x});
            }
            return res;
        }
    }

}
