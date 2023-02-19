package leetcode.leetcode202302;

import javafx.collections.transformation.SortedList;

import java.util.*;

public class leetcode_1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            long va = (long) (a[1] - a[0]) * (b[1] + 1) * b[1];
            long vb = (long) (b[1] - b[0]) * (a[1] + 1) * a[1];
            if (va == vb) {
                return 0;
            }
            return vb > va ? 1 : -1;
        });

        for (int[] aClass : classes) {
            priorityQueue.add(aClass);
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] poll = priorityQueue.poll();
            poll[0]++;
            poll[1]++;
            priorityQueue.offer(poll);
        }

        double ans = 0;
        for (int[] aClass : classes) {
            ans += ((double) aClass[0] / (double) aClass[1]);
        }
        return ans / classes.length;

    }



    public static void main(String[] args) {
        int[][] classes = new int[][]{{2,4},{3,9},{4,5},{2,10}};
        System.out.println(new leetcode_1792().maxAverageRatio(classes, 4));
    }
}
