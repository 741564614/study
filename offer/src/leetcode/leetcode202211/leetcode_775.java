package leetcode.leetcode202211;

public class leetcode_775 {
    public boolean isIdealPermutation(int[] nums) {
        int allNum = 0, localNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > i) {
                allNum += (nums[i] - i);
                if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                    localNum++;
                }
            }
        }
        return allNum == localNum;
    }

    public boolean isIdealPermutation02(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < i - 1 || nums[i] > i + 1) return false;
        }
        return true;
    }
}
