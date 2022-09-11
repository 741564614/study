package leetcode.leetcode202209;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode_857 {
    public static void main(String[] args) {

    }

    public double mincostToHireWorkers02(int[] quality, int[] wage, int k) {
        Integer[] h = new Integer[quality.length];
        for (int i = 0; i < h.length; i++) {
            h[i] = i;
        }
        Arrays.sort(h, (a, b) -> wage[a] * quality[b] - wage[b] * quality[a]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        Double res = 1e9;
        Integer totalq = 0;
        for (int i = 0; i < k - 1; i++) {
            totalq += quality[h[i]];
            queue.offer(quality[h[i]]);
        }
        for (int i = k - 1; i < h.length; i++) {
            totalq += quality[h[i]];
            queue.offer(quality[h[i]]);
            Double totalc = totalq * ((double) wage[h[i]] / quality[h[i]]);
            res=Math.min(res,totalc);
            totalq-=queue.poll();
        }
        return res;
    }
}
