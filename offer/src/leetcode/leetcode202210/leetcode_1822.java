package leetcode.leetcode202210;

public class leetcode_1822 {
    public int arraySign(int[] nums) {
        boolean check = true;
        for (int num : nums) {
            if (num < 0) {
                check = !check;
            }
            if (num == 0) {
                return 0;
            }
        }
        return check ? 1 : -1;
    }
}
