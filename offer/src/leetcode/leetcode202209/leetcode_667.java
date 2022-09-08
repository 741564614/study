package leetcode.leetcode202209;

public class leetcode_667 {
    public static void main(String[] args) {

    }

    public int[] constructArray02(int n, int k) {
        int[] ans = new int[n];
        int t = n - k - 1;
        for (int i = 0; i < t; i++) {
            ans[i] = i + 1;
        }
        for (int i = t, a = n - k, b = n; i < n; ) {
            ans[i++] = a++;
            if (i < n) {
                ans[i++] = b--;
            }
        }
        return ans;
    }
}
