package leetcode.leetcode202209;

import java.util.Arrays;

public class leetcode_1652 {
    public static void main(String[] args) {
        int[] ans = new int[]{2, 4, 9, 3};
        System.out.println(Arrays.toString(decrypt(ans, -2)));
    }

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int sum = 0;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        if (k > 0) {
            int index = 0;
            for (int i = 0; i < k; i++) {
                sum += code[i % n];
            }
            for (int i = 0; i < code.length; i++) {
                ans[i] = sum - code[i] + code[(index + k) % n];
                sum = ans[i];
                index++;
            }
        } else {
            k = Math.abs(k);
            int index = n-1;
            for (int i = 0; i < k; i++) {
                sum += code[(n -1- i) % n];
            }
            for (int i = code.length - 1; i >= 0; i--) {
                ans[i] = sum - code[i] + code[(index-k+n) % n];
                sum = ans[i];
                index--;
            }
        }

        return ans;
    }

    public int[] decrypt02(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) return ans;
        int[] sum = new int[n * 2 + 10];
        for (int i = 1; i <= 2 * n; i++) sum[i] += sum[i - 1] + code[(i - 1) % n];
        for (int i = 1; i <= n; i++) {
            if (k < 0) ans[i - 1] = sum[i + n - 1] - sum[i + n + k - 1];
            else ans[i - 1] = sum[i + k] - sum[i];
        }
        return ans;
    }
}
