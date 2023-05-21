package leetcode.leetcode202305;

import java.util.PriorityQueue;

public class LCP_33 {

    public int storeWater(int[] bucket, int[] vat) {
        int ans = Integer.MAX_VALUE;
        int n = bucket.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (bucket[a] == 0 || vat[b] == 0) {
                return -1;
            } else if (bucket[b] == 0 || vat[a] == 0) {
                return 1;
            }
            return (vat[b] / bucket[b] + (vat[b] % bucket[b] == 0 ? 0 : 1)) - (vat[a] / bucket[a] + (vat[a] % bucket[a] == 0 ? 0 : 1));
        });
        for (int i = 0; i < n; i++) {
            if (vat[i] != 0) {
                priorityQueue.add(i);
            }
        }
        if (priorityQueue.isEmpty()) {
            return 0;
        }
        int step = 0;
        while (step < ans) {
            int index = priorityQueue.poll();
            if (bucket[index] != 0) {
                int next = step + (vat[index] / bucket[index] + (vat[index] % bucket[index] == 0 ? 0 : 1));
                ans = Math.min(ans, next);
            }
            step++;
            bucket[index]++;
            priorityQueue.offer(index);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] a = new int[]{0};
        int[] b = new int[]{1};
        System.out.println(new LCP_33().storeWater(a, b));
    }

}
