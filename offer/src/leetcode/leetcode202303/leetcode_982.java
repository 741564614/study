package leetcode.leetcode202303;

public class leetcode_982 {
    public int countTriplets(int[] nums) {
        int[] count = new int[1 << 16];
        for (int x : nums) {
            for (int y : nums) {
                count[x & y]++;
            }
        }

        int ans = 0;
        for (int num : nums) {
            for (int i = 0; i < 1 << 16; i++) {
                if ((num & i) == 0) {
                    ans += count[i];
                }
            }
        }
        return ans;
    }

    public int countTriplets02(int[] nums) {
        int[] count = new int[1 << 16];
        for (int x : nums) {
            for (int y : nums) {
                count[x & y]++;
            }
        }

        int ans = 0;
        for (int num : nums) {
            int x = num ^ (0xffff);
            for (int sub = x; sub > 0; sub = (sub - 1) & x) {
                ans += count[sub];
            }
            ans+=count[0];
        }
        return ans;
    }
}
