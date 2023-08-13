package leetcode.leetcode202308;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx1 = 0, idx2 = 0;
        while (idx1 < m && idx2 < n) {
            if (!pq.isEmpty()) {
                int peek = pq.peek();
                if (peek <= nums1[idx1] && peek <= nums2[idx2]) {
                    int temp = nums1[idx1];
                    nums1[idx1++] = peek;
                    pq.poll();
                    pq.offer(temp);
                } else if (nums2[idx2] <= peek && nums2[idx2] <= nums1[idx1]) {
                    pq.offer(nums1[idx1]);
                    nums1[idx1++] = nums2[idx2++];
                } else {
                    idx1++;
                }
            } else {
                if (nums1[idx1] <= nums2[idx2]) {
                    idx1++;
                } else {
                    pq.offer(nums1[idx1]);
                    nums1[idx1++] = nums2[idx2++];
                }
            }
        }
        while (!pq.isEmpty() && idx2 < n) {
            int peek = pq.peek();
            if (peek <= nums2[idx2]) {
                nums1[idx1++] = pq.poll();
            } else {
                nums1[idx1++] = nums2[idx2++];
            }
        }
        while (!pq.isEmpty() && idx1 < m) {
            int peek = pq.peek();
            if (peek <= nums1[idx1]) {
                peek = pq.poll();
                pq.offer(nums1[idx1]);
                nums1[idx1++] = peek;
            } else {
                idx1++;
            }
        }
        while (!pq.isEmpty()) {
            nums1[idx1++] = pq.poll();
        }
        while (idx2 < n) {
            nums1[idx1++] = nums2[idx2++];
        }
    }

    public void merge20(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1, idx = m + n - 1;
            while(i >= 0 && j >= 0)
            {
                if(nums1[i] >= nums2[j]) nums1[idx--] = nums1[i--];
                else nums1[idx--] = nums2[j--];
            }
            while(j >= 0) nums1[idx--] = nums2[j--];
        }
    }
}
