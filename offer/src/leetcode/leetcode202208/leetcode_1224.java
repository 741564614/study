package leetcode.leetcode202208;

public class leetcode_1224 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,2,2,2,2,1};
        System.out.println(maxEqualFreq2(nums));
    }

    public static int maxEqualFreq2(int[] nums) {
        int[] cnt = new int[100010], sum = new int[100010];
        int ans = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = ++cnt[nums[i]];
            sum[cur]++;
            sum[cur - 1]--;
            max = Math.max(max, cur);
            if (max == 1 || (max * sum[max] == i) || ((max - 1) * (sum[max - 1] + 1) == i)) {
                ans = i + 1;
            }
        }
        return ans;
    }
}
