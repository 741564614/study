package offer;

import java.util.*;

public class offer_59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int l = 0, r = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((a, b) -> b - a);
        int[] ans = new int[nums.length - k + 1];
        while (r < k) {
            treeMap.put(nums[r], treeMap.getOrDefault(nums[r], 0) + 1);
            r++;
        }
        r--;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = treeMap.firstEntry().getKey();
            if (r + 1 < nums.length) {
                r++;
                treeMap.put(nums[r], treeMap.getOrDefault(nums[r], 0) + 1);
                treeMap.put(nums[l], treeMap.get(nums[l]) - 1);
                if (treeMap.get(nums[l]) <= 0) {
                    treeMap.remove(nums[l]);
                }
                l++;
            }
        }
        return ans;
    }

    public int[] maxSlidingWindow02(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow03(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }

        return ans;
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) {
                return new int[0];
            }
            int n = nums.length;
            int[] prefixMax = new int[n];
            int[] suffixMax = new int[n];
            for (int i = 0; i < n; ++i) {
                if (i % k == 0) {
                    prefixMax[i] = nums[i];
                }
                else {
                    prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
                }
            }
            for (int i = n - 1; i >= 0; --i) {
                if (i == n - 1 || (i + 1) % k == 0) {
                    suffixMax[i] = nums[i];
                } else {
                    suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
                }
            }

            int[] ans = new int[n - k + 1];
            for (int i = 0; i <= n - k; ++i) {
                ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
            }
            return ans;
        }
    }
}
