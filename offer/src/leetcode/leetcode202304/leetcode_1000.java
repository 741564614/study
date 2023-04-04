package leetcode.leetcode202304;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_1000 {

    public static void main(String[] args) {
        int[] stones=new int[]{6,4,4,6};
//        System.out.println(new leetcode_1000().mergeStones(stones,2));
    }

//    public int mergeStones(int[] stones, int k) {
//        int n = stones.length;
//        if (n == k) {
//            return Arrays.stream(stones).sum();
//        }
//        while (n >= k) {
//            n -= (k - 1);
//        }
//        if (n != 1) {
//            return -1;
//        }
//        List<Integer> stoneList = new ArrayList<>();
//        List<Integer> prefixList = new ArrayList<>();
//        stoneList.add(stones[0]);
//        prefixList.add(stones[0]);
//        for (int i = 1; i < stones.length; i++) {
//            stoneList.add(stones[i]);
//            prefixList.add(prefixList.get(i - 1) + stones[i]);
//        }
//
//        int ans = 0;
//        while (stoneList.size() > 1) {
//            int start = 0, min = Integer.MAX_VALUE;
//
//            for (int i = 0; i <= stoneList.size() - k; i++) {
//                int cost = prefixList.get(i + k - 1) - prefixList.get(i) + stoneList.get(i);
//                if (cost < min) {
//                    min = cost;
//                    start = i;
//                }
//            }
//
//            for (int i = start + k - 1; i >= start; i--) {
//                stoneList.remove(i);
//                prefixList.remove(i);
//            }
//
//            stoneList.add(start, min);
//            prefixList.add(start, start == 0 ? min : prefixList.get(start - 1) + min);
//            ans += min;
//        }
//
//        return ans;
//
//    }

    class Solution {
        static final int INF = 0x3f3f3f3f;

        public int mergeStones(int[] stones, int k) {
            int n = stones.length;
            if ((n - 1) % (k - 1) != 0) {
                return -1;
            }

            int[][] d = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(d[i], INF);
            }
            int[] sum = new int[n];

            for (int i = 0, s = 0; i < n; i++) {
                d[i][i] = 0;
                s += stones[i];
                sum[i] = s;
            }

            for (int len = 2; len <= n; len++) {
                for (int l = 0; l < n && l + len - 1 < n; l++) {
                    int r = l + len - 1;
                    for (int p = l; p < r; p += k - 1) {
                        d[l][r] = Math.min(d[l][r], d[l][p] + d[p + 1][r]);
                    }
                    if ((r - l) % (k - 1) == 0) {
                        d[l][r] += sum[r] - (l == 0 ? 0 : sum[l - 1]);
                    }
                }
            }
            return d[0][n - 1];
        }
    }

}
