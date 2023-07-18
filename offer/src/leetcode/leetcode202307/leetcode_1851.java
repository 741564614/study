package leetcode.leetcode202307;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_1851 {
    public int[] minInterval02(int[][] intervals, int[] queries) {
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(a -> queries[a]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[queries.length];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int p = 0;
        for (Integer i : index) {
            while (p < intervals.length && intervals[p][0] <= queries[i]) {
                priorityQueue.offer(new int[]{intervals[p][1] - intervals[p][0] + 1, intervals[p][0], intervals[p][1]});
                p++;
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[2] < queries[i]) {
                priorityQueue.poll();
            }
            ans[i] = priorityQueue.isEmpty() ? -1 : priorityQueue.peek()[0];
        }
        return ans;
    }
}
