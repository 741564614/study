package leetcode.leetcode202301;

import java.util.*;

public class leetcode_1658 {

    public static void main(String[] args) {
        System.out.println(new leetcode_1658().minOperations(new int[]{1,1},3));
    }

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        Map<Integer, Integer> suffixMap = new HashMap();

        int suffixSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixSum += nums[i];
            suffixMap.put(suffixSum, i);
        }

        int prefixSum = 0;
        int ans = Integer.MAX_VALUE;
        if (suffixMap.containsKey(x - prefixSum)) {
            int j = n - suffixMap.get(x - prefixSum);
            ans = Math.min(ans, j);
        }
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == x) {
                ans = Math.min(ans, i + 1);
            } else if (prefixSum > x) {
                return ans;
            } else {
                if (suffixMap.containsKey(x - prefixSum)) {
                    Integer k = suffixMap.get(x - prefixSum);
                    if(k!=i){
                        int j = n - suffixMap.get(x - prefixSum);
                        ans = Math.min(ans, j + i + 1);
                    }
                }
            }
        }

        return ans;

    }

    public int minOperations02(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum < x) {
            return -1;
        }

        int right = 0;
        int lsum = 0, rsum = sum;
        int ans = n + 1;

        for (int left = -1; left < n; ++left) {
            if (left != -1) {
                lsum += nums[left];
            }
            while (right < n && lsum + rsum > x) {
                rsum -= nums[right];
                ++right;
            }
            if (lsum + rsum == x) {
                ans = Math.min(ans, (left + 1) + (n - right));
            }
        }

        return ans > n ? -1 : ans;
    }

}
