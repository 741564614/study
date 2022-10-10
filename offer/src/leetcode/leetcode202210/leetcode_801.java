package leetcode.leetcode202210;

public class leetcode_801 {
    public int minSwap02(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] f = new int[n][2];
        for (int i = 1; i < n; i++) {
            f[i][0] = n + 10;
            f[i][1] = n + 10;
        }
        f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                f[i][0] = f[i - 1][0];
                f[i][1] = f[i - 1][1] + 1;
            }
            if (nums2[i] > nums1[i - 1] && nums1[i] > nums2[i - 1]) {
                f[i][0] = Math.min(f[i][0], f[i - 1][1]);
                f[i][1] = Math.min(f[i - 1][0] + 1, f[i][1]);
            }
        }
        return Math.min(f[n - 1][0], f[n - 1][1]);
    }
}
