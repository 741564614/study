package leetcode.leetcode202210;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode_862 {
    public static void main(String[] args) {
        int[] n = new int[]{-34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6};
        System.out.println(shortestSubarray02(n, 151));
    }

    public static int shortestSubarray02(int[] nums, int k) {
        int n = nums.length;
        int res = n + 1;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSum[i];
            while (!deque.isEmpty() && curSum - preSum[deque.peekFirst()] >= k) {
                res = Math.min(res, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && preSum[deque.peekLast()] > curSum) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return res == n + 1 ? -1 : res;
    }
}
