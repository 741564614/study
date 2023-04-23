package leetcode.leetcode202304;

import java.util.Arrays;

public class leetcode_1105 {

    public static void main(String[] args) {
        int[][] books = new int[][]{{2, 7}, {9, 1}, {6, 1}, {4, 2}, {3, 3}, {8, 6}, {10, 3}, {1, 10}};
        System.out.println(new leetcode_1105().minHeightShelves02(books, 10));
    }

    public int minHeightShelves02(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < books.length; i++) {
            int curWidth = 0, curHeight = 0;
            for (int j = i; j >= 0; j--) {
                curHeight = Math.max(curHeight, books[j][1]);
                curWidth += books[j][0];
                if (curWidth > shelfWidth) {
                    break;
                }
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + curHeight);
            }
        }
        return dp[books.length];
    }
}
