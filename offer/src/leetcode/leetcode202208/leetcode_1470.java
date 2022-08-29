package leetcode.leetcode202208;

public class leetcode_1470 {
    public static void main(String[] args) {

    }

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < 2 * n; i += 2) {
            ans[i] = nums[i / 2];
            ans[i + 1] = nums[n + i / 2];
        }
        return ans;
    }
}
