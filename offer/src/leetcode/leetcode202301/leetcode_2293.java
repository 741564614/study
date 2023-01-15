package leetcode.leetcode202301;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode_2293 {
    public int minMaxGame(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            queue.offer(num);
        }
        while (queue.size() != 1) {
            int size = queue.size();
            boolean isMin = true;
            for (int i = 0; i < size; i += 2) {
                Integer a = queue.poll();
                Integer b = queue.poll();
                queue.offer(isMin ? Math.min(a, b) : Math.max(a, b));
                isMin = !isMin;
            }
        }
        return queue.peek();
    }
    public int minMaxGame20(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] newNums = new int[n / 2];
        for (int i = 0; i < newNums.length; i++) {
            if (i % 2 == 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newNums);
    }
}
