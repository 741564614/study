package leetcode.leetcode202209;

import java.util.*;

public class leetcode_646 {
    public static void main(String[] args) {
        int[][] pairs = new int[][]{{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
        System.out.println(findLongestChain(pairs));
    }


    public static int findLongestChain(int[][] pairs) {
        int max = 0, cur = Integer.MIN_VALUE;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        for (int[] pair : pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                max++;
            }
        }
        return max;
    }


}
