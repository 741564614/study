package leetcode.leetcode202305;

import java.util.*;

public class leetcode_2106 {

    public static void main(String[] args) {
        int[][] f = new int[][]{{0, 7}, {7, 4}, {9, 10}, {12, 6}, {14, 8}, {16, 5}, {17, 8}, {19, 4}, {20, 1}, {21, 3}, {24, 3}, {25, 3}, {26, 1}, {28, 10}, {30, 9}, {31, 6}, {32, 1}, {37, 5}, {40, 9}};
        System.out.println(new leetcode_2106().maxTotalFruits(f, 21, 30));
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxLen = fruits[fruits.length - 1][0];
        int[] prefixSum = new int[400001];
        int index = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            int value = prefixSum[i - 1];
            if (index < fruits.length && (i - 1) >= fruits[index][0]) {
                value += fruits[index++][1];
            }
            prefixSum[i] = value;
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            //先往左，再折回来
            int left = Math.max(startPos - i, 0);
            int right = Math.min(maxLen, Math.max(k - 2 * i + startPos, startPos));
            ans = Math.max(ans, prefixSum[right + 1] - prefixSum[left]);

            //先往右，再折回来
            int right2 = Math.min(startPos + i, maxLen);
            int left2 = Math.max(startPos - Math.max(k - 2 * i, 0), 0);
            ans = Math.max(ans, prefixSum[right2 + 1] - prefixSum[left2]);
        }
        return ans;
    }

    public int maxTotalFruits02(int[][] fruits, int startPos, int k) {
        int left = 0, right = 0, sum = 0, ans = 0;
        int n = fruits.length;
        while (right < n) {
            sum += fruits[right][1];
            while (left <= right && step(fruits[right][0], fruits[left][0], startPos) > k) {
                sum -= fruits[left++][1];
            }
            ans = Math.max(ans, sum);
            right++;
        }
        return ans;
    }

    public int step(int right, int left, int startPos) {
        return Math.min(Math.abs(startPos - right), Math.abs(startPos - left)) + right - left;
    }
}
