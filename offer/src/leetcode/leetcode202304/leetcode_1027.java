package leetcode.leetcode202304;

import java.util.*;

public class leetcode_1027 {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(dp[i]==null){
                dp[i]=new HashMap<>();
            }
            for (int j = i - 1; j >= 0 && j + 1 >= max; j--) {
                int diff = nums[i] - nums[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                max = Math.max(max, len);
                dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 2), len));
            }
        }
        return max;
    }

    class Solution {
        public int longestArithSeqLength(int[] nums) {
            int minv = Arrays.stream(nums).min().getAsInt();
            int maxv = Arrays.stream(nums).max().getAsInt();
            int diff = maxv - minv;
            int ans = 1;
            for (int d = -diff; d <= diff; ++d) {
                int[] f = new int[maxv + 1];
                Arrays.fill(f, -1);
                for (int num : nums) {
                    int prev = num - d;
                    if (prev >= minv && prev <= maxv && f[prev] != -1) {
                        f[num] = Math.max(f[num], f[prev] + 1);
                        ans = Math.max(ans, f[num]);
                    }
                    f[num] = Math.max(f[num], 1);
                }
            }
            return ans;
        }
    }

    class Solution02 {
        public int longestArithSeqLength(int[] nums) {

            int[][] dp = new int[nums.length][1001];
            int max = 0;
            for(int i=1;i<nums.length;i++){
                for(int j=i-1;j>=0;j--){
                    int d = nums[i]-nums[j]+500;
                    if(dp[i][d]==0) {
                        dp[i][d] = dp[j][d] + 1;
                        max = Math.max(max,dp[i][d]);
                    }
                }
            }
            return max+1;
        }
    }


}
