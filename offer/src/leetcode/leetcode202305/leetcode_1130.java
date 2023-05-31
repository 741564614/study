package leetcode.leetcode202305;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class leetcode_1130 {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 12, 2, 2, 3, 13, 8, 4, 9, 12, 9, 3, 10, 4, 13, 7, 5, 15};
        System.out.println(new leetcode_1130().mctFromLeafValues(arr));
    }

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] max = new int[n][n];
        note = new int[n][n];
        for (int i = 0; i < max.length; i++) {
            int cur = arr[i];
            for (int j = i; j < max.length; j++) {
                cur = Math.max(cur, arr[j]);
                max[i][j] = cur;
            }
        }
        return dfs(max, 0, n - 1);
    }

    int[][] note;

    public int dfs(int[][] max, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (note[start][end] != 0) {
            return note[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end - 1; i++) {
            min = Math.min(min, max[start][i] * max[i + 1][end] + dfs(max, start, i) + dfs(max, i + 1, end));
        }
        note[start][end] = min;
        return min;
    }


    class Solution {
        public int mctFromLeafValues(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE / 4);
            }
            int[][] mval = new int[n][n];
            for (int j = 0; j < n; j++) {
                mval[j][j] = arr[j];
                dp[j][j] = 0;
                for (int i = j - 1; i >= 0; i--) {
                    mval[i][j] = Math.max(arr[i], mval[i + 1][j]);
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + mval[i][k] * mval[k + 1][j]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }


    class Solution02 {
        public int mctFromLeafValues(int[] arr) {
            int res = 0;
            Deque<Integer> stk = new ArrayDeque<Integer>();
            for (int x : arr) {
                while (!stk.isEmpty() && stk.peek() <= x) {
                    int y = stk.pop();
                    if (stk.isEmpty() || stk.peek() > x) {
                        res += y * x;
                    } else {
                        res += stk.peek() * y;
                    }
                }
                stk.push(x);
            }
            while (stk.size() >= 2) {
                int x = stk.pop();
                res += stk.peek() * x;
            }
            return res;
        }
    }


}
