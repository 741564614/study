package leetcode.leetcode202306;

import java.util.*;
import java.util.Queue;

public class leetcode_1186 {
    public static void main(String[] args) {
        int[] k = new int[]{8, -1, 6, -7, -4, 5, -4, 7, -6};
        System.out.println(new leetcode_1186().maximumSum02(k));
    }

    public int maximumSum02(int[] arr) {
        int n = arr.length;
        int dp0 = arr[0], dp1 = arr[0], max = arr[0];
        for (int i = 1; i < n; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = Math.max(dp0, 0) + arr[i];
            max = Math.max(max, Math.max(dp0, dp1));
        }
        return max;
    }
}
