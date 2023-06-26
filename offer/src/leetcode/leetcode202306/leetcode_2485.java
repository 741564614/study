package leetcode.leetcode202306;

public class leetcode_2485 {
    public int pivotInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        int prefix = 0;
        for (int i = 1; i <= n; i++) {
            prefix += i;
            if (prefix == (sum + i - prefix)) {
                return i;
            }
        }
        return -1;
    }

    class Solution {
        public int pivotInteger(int n) {
            int t = (n * n + n) / 2;
            int x = (int) Math.sqrt(t);
            if (x * x == t) {
                return x;
            }
            return -1;
        }
    }

}
