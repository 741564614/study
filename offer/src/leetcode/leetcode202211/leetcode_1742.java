package leetcode.leetcode202211;

public class leetcode_1742 {

    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        int[] nums = new int[10010];
        for (int i = lowLimit; i <= highLimit; i++) {
            int num = getNum(i);
            nums[num]++;
            max = Math.max(nums[num], max);
        }
        return max;
    }

    public int getNum(int a) {
        int ans = 0;
        while (a > 0) {
            ans += (a % 10);
            a /= 10;
        }
        return ans;
    }
}
