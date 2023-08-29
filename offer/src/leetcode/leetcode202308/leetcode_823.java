package leetcode.leetcode202308;

import java.util.*;

public class leetcode_823 {

    public static void main(String[] args) {
        System.out.println(new leetcode_823().numFactoredBinaryTrees(new int[]{2,4,5,10}));
    }

    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length,  mod = 1000000007;
        long ans=0;
        long[] dp = new long[n];
        Arrays.sort(arr);
        Map<Double, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put((double) arr[i], i);
        }
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                double other = arr[i] / (double) arr[j];
                if (indexMap.containsKey(other)) {
                    dp[i] = (dp[i] + (dp[j] * dp[indexMap.get(other)]) % mod) % mod;
                }
            }
        }

        for (long val : dp) {
            ans = (ans + val) % mod;
        }

        return (int) ans;
    }

    class Solution {
        public int numFactoredBinaryTrees(int[] arr) {
            Arrays.sort(arr);
            int n = arr.length;
            long[] dp = new long[n];
            long res = 0, mod = 1000000007;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int left = 0, right = i - 1; left <= right; left++) {
                    while (right >= left && (long) arr[left] * arr[right] > arr[i]) {
                        right--;
                    }
                    if (right >= left && (long) arr[left] * arr[right] == arr[i]) {
                        if (right != left) {
                            dp[i] = (dp[i] + dp[left] * dp[right] * 2) % mod;
                        } else {
                            dp[i] = (dp[i] + dp[left] * dp[right]) % mod;
                        }
                    }
                }
                res = (res + dp[i]) % mod;
            }
            return (int) res;
        }
    }

}
