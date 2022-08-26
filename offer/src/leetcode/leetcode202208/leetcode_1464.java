package leetcode.leetcode202208;

public class leetcode_1464 {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int max = 0, nextMax = 0;
        for (int num : nums) {
            if (num >= max) {
                nextMax = max;
                max = num;
            } else {
                nextMax = Math.max(nextMax, num);
            }
        }
        return (max - 1) * (nextMax - 1);
    }
}
