package leetcode.leetcode202210;

public class leetcode_915 {
    public static void main(String[] args) {
        int[] t = new int[]{5, 0, 3, 8, 6};
        System.out.println(partitionDisjoint(t));
    }

    public int partitionDisjoint02(int[] nums) {
        int n = nums.length;
        int[] min = new int[n + 10];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) min[i] = Math.min(min[i + 1], nums[i]);
        for (int i = 0, max = 0; i < n - 1; i++) {
            max = Math.max(max, nums[i]);
            if (max <= min[i + 1]) return i + 1;
        }
        return -1; // never
    }

    public static int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        int min = Integer.MAX_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            suffix[i] = min;
        }
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max <= suffix[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }
}
