package leetcode.leetcode202305;

public class leetcode_1330 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
//        System.out.println(new leetcode_1330().maxValueAfterReverse(nums));
    }

//    public int maxValueAfterReverse(int[] nums) {
//        int ans = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            ans += Math.abs(nums[i] - nums[i + 1]);
//        }
//        int max = ans;
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int now = ans;
//                if (i > 0) {
//                    now -= Math.abs(nums[i] - nums[i - 1]);
//                    now += Math.abs(nums[j] - nums[i - 1]);
//                }
//                if (j < nums.length - 1) {
//                    now -= Math.abs(nums[j] - nums[j + 1]);
//                    now += Math.abs(nums[i] - nums[j + 1]);
//                }
//                max = Math.max(max, now);
//            }
//        }
//        return max;
//    }

//    public int maxValueAfterReverse(int[] nums) {
//        int ans = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            ans += Math.abs(nums[i] - nums[i + 1]);
//        }
//        int max = ans;
//        for (int k = nums.length - 1; k >= 1; k--) {
//            for (int i = 0, j = i + k; i < nums.length && j < nums.length; i++) {
//                int now = ans;
//                if (i > 0) {
//                    now -= Math.abs(nums[i] - nums[i - 1]);
//                    now += Math.abs(nums[j] - nums[i - 1]);
//                }
//                if (j < nums.length - 1) {
//                    now -= Math.abs(nums[j] - nums[j + 1]);
//                    now += Math.abs(nums[i] - nums[j + 1]);
//                }
//                max = Math.max(max, now);
//            }
//        }
//        return max;
//    }

    class Solution {
        public int maxValueAfterReverse(int[] nums) {
            int value = 0, n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                value += Math.abs(nums[i] - nums[i + 1]);
            }
            int mx1 = 0;
            for (int i = 1; i < n - 1; i++) {
                mx1 = Math.max(mx1, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
                mx1 = Math.max(mx1, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
            }
            int mx2 = Integer.MIN_VALUE, mn2 = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                int x = nums[i], y = nums[i + 1];
                mx2 = Math.max(mx2, Math.min(x, y));
                mn2 = Math.min(mn2, Math.max(x, y));
            }
            return value + Math.max(mx1, 2 * (mx2 - mn2));
        }
    }

}
