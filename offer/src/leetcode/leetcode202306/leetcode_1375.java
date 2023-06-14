package leetcode.leetcode202306;

public class leetcode_1375 {

    public static void main(String[] args) {
        int[] f = new int[]{3, 2, 4, 1, 5};
        System.out.println(new leetcode_1375().numTimesAllBlue(f));
    }

    public int numTimesAllBlue(int[] flips) {
        int maxLeft = 0;
        int[] check = new int[flips.length + 1];
        int ans = 0;
        for (int i = 0; i < flips.length; i++) {
            check[flips[i]] = 1;
            if (flips[i] == maxLeft || flips[i] == 1) {
                check[0] = 1;
                while (maxLeft < check.length && check[maxLeft] == 1) {
                    maxLeft++;
                }
            }
            ans += maxLeft > i + 1 ? 1 : 0;
        }
        return ans;
    }

    class Solution {
        public int numTimesAllBlue(int[] flips) {
            int n = flips.length;
            int ans = 0, right = 0;
            for (int i = 0; i < n; ++i) {
                right = Math.max(right, flips[i]);
                if (right == i + 1) {
                    ++ans;
                }
            }
            return ans;
        }
    }
}
