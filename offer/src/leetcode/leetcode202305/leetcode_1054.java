package leetcode.leetcode202305;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class leetcode_1054 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 1, 5};
        System.out.println(Arrays.toString(new leetcode_1054().rearrangeBarcodes(nums)));
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes.length == 1) {
            return barcodes;
        }
        int[] cnt = new int[10001];
        for (int barcode : barcodes) {
            cnt[barcode]++;
        }
        LinkedList<Integer> priorityQueue = new LinkedList<>();
        for (int i = 0; i < 10001; i++) {
            if (cnt[i] > 0) {
                priorityQueue.offer(i);
            }
        }
        priorityQueue.sort((a, b) -> cnt[b] - cnt[a]);
        int j = priorityQueue.poll();
        for (int i = 0; i < 2; i++) {
            for (int k = i; k < barcodes.length; k += 2) {
                barcodes[k] = j;
                cnt[j]--;
                if (cnt[j] == 0 && !priorityQueue.isEmpty()) {
                    j = priorityQueue.poll();
                }
            }
        }
        return barcodes;
    }
}
