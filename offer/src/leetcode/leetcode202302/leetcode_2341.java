package leetcode.leetcode202302;

public class leetcode_2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int[] ans = new int[2];
        for (int i : count) {
            ans[0] += i / 2;
            ans[1] += i % 2;
        }
        return ans;
    }
}
