package leetcode.leetcode202212;

public class leetcode_1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long ans = 0;
        for (int num : nums) {
            ans += num;
        }
        long dff = Math.abs(ans - goal);
        return dff % limit == 0 ? (int) (dff / limit ): (int) (dff / limit) + 1;
    }
}
