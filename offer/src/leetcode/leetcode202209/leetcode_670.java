package leetcode.leetcode202209;

public class leetcode_670 {
    public static void main(String[] args) {

    }

    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }
        int len = String.valueOf(num).length();
        int[] note = new int[len], nums = new int[len];
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = num % 10;
            num /= 10;
            note[len-i-1] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            note[i] = Math.max(nums[nums.length - i - 1], note[i - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < note[nums.length - i - 1]) {
                int def = nums[i];
                nums[i] = note[nums.length - i - 1];
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] == nums[i]) {
                        nums[j] = def;
                        break;
                    }
                }
                break;
            }
        }

        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans += (nums[i] * Math.pow(10, len - i - 1));
        }
        return ans;
    }

}
