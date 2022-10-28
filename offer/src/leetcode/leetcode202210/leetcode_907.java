package leetcode.leetcode202210;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class leetcode_907 {
    int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins02(int[] arr) {
        int n = arr.length, ans = 0;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && arr[d.peekLast()] >= arr[i]) r[d.pollLast()] = i;
            d.addLast(i);
        }
        d.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!d.isEmpty() && arr[d.peekLast()] > arr[i]) l[d.pollLast()] = i;
            d.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            int a = i - l[i], b = r[i] - i;
            ans += (long) a * b % MOD * arr[i] % MOD;
            ans %= MOD;
        }
        return ans;
    }

}
