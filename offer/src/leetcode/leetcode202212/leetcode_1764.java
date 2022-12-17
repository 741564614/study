package leetcode.leetcode202212;

public class leetcode_1764 {
    public static void main(String[] args) {
        int[][] groups = new int[][]{{1, -1, -1}, {3, -2, 0}};
        int[] nums = new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0};
        System.out.println(new leetcode_1764().canChoose(groups, nums));
    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int q = 0;
        for (int[] group : groups) {
            int k = q;
            int i = 0;
            while (i < group.length && k < nums.length) {
                if (nums[k] != group[i]) {
                    q++;
                    k = q;
                    i = 0;
                } else {
                    k++;
                    i++;
                }
            }
            if (k == nums.length && i != group.length) {
                return false;
            }
            q = k;
        }
        return true;
    }
}
