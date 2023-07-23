package leetcode.leetcode202307;

public class leetcode_42 {
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        int[] right = new int[len];
        right[len - 1] = height[len - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int ans = 0, left = height[0];
        for (int i = 1; i < height.length - 1; i++) {
            if (left > height[i] && height[i] < right[i + 1]) {
                ans += Math.min(left, right[i + 1]) - height[i];
            }
            left = Math.max(left, height[i]);
        }
        return ans;
    }
}
