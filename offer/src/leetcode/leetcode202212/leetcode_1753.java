package leetcode.leetcode202212;

import java.util.Arrays;

public class leetcode_1753 {
    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int ans = 0;
        if (arr[0] + arr[1] >= arr[2]) {
            ans += (arr[0] + arr[1] - arr[2]) / 2;
            ans += arr[2];
        } else {
            ans += (arr[0] + arr[1]);
        }
        return ans;
    }
}
