package leetcode.leetcode202309;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> (double)dist[a] / speed[a]));
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }
        int ans = 0, m = 0;
        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            if (dist[poll] - m * speed[poll] <= 0) {
                return ans;
            }
            ans++;
            m++;
        }
        return ans;
    }

    class Solution {
        public int eliminateMaximum(int[] dist, int[] speed) {
            int n = dist.length;
            int[] arrivalTimes = new int[n];
            for (int i = 0; i < n; i++) {
                arrivalTimes[i] = (dist[i] - 1) / speed[i] + 1;
            }
            Arrays.sort(arrivalTimes);
            for (int i = 0; i < n; i++) {
                if (arrivalTimes[i] <= i) {
                    return i;
                }
            }
            return n;
        }
    }

}
