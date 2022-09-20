package leetcode.leetcode202209;

import java.util.Arrays;

public class leetcode_698 {
    public static void main(String[] args) {
        int[] nums = new int[]{3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269};
//        System.out.println(canPartitionKSubsets(nums, 5));
    }

    //    public static boolean canPartitionKSubsets(int[] nums, int k) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if (sum % k != 0) {
//            return false;
//        }
//        int avg = sum / k;
//        Arrays.sort(nums);
//        boolean[] check = new boolean[nums.length];
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (!check[i]) {
//                int temp = nums[i];
//                check[i] = true;
//                for (int j = i - 1; j >= 0; j--) {
//                    if (!check[j] && (temp + nums[j]) <= avg) {
//                        temp += nums[j];
//                        check[j] = true;
//                    }
//                    if (temp == avg) {
//                        break;
//                    }
//                }
//                if (temp != avg) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
    int[] nums;
    int per, n;
    boolean[] dp;

    public boolean canPartitionKSubsets02(int[] nums, int k) {
        this.nums = nums;
        int all = Arrays.stream(nums).sum();
        if (all % k != 0) {
            return false;
        }
        per = all / k;
        Arrays.sort(nums);
        n = nums.length;
        if (nums[n - 1] > per) {
            return false;
        }
        dp = new boolean[1 << n];
        Arrays.fill(dp, true);
        return dfs((1 << n) - 1, 0);
    }

    public boolean dfs(int s, int p) {
        if (s == 0) {
            return true;
        }
        if (!dp[s]) {
            return dp[s];
        }
        dp[s] = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] + p > per) {
                break;
            }
            if (((s >> i) & 1) != 0) {
                if (dfs(s ^ (1 << i), (p + nums[i]) % per)) {
                    return true;
                }
            }
        }
        return false;
    }


}
