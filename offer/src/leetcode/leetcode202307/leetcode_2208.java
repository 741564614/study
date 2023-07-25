package leetcode.leetcode202307;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_2208 {

    public int halveArray(int[] nums) {
        double sum = 0, cut = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            sum += num;
            pq.offer((double) num);
        }
        int ans = 0;
        while (cut * 2 < sum) {
            Double next = pq.poll() / 2;
            cut += next;
            pq.offer(next);
            ans++;
        }
        return ans;
    }
}
