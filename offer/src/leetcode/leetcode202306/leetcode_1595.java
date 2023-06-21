package leetcode.leetcode202306;

import java.util.*;

public class leetcode_1595 {
//    public int connectTwoGroups(List<List<Integer>> cost) {
//        boolean[] size1 = new boolean[cost.size()];
//        boolean[] size2 = new boolean[cost.get(0).size()];
//        int ans = 0;
//        for (int i = 0; i < size1.length; i++) {
//            int min=0,minIndex=0;
//            for (int j = 0; j < cost.get(i).size(); j++) {
//                Integer value = cost.get(i).get(j);
//                if(value<min){
//                    min=value;
//                    minIndex=j;
//                }
//            }
//            ans+=min;
//            size1[i] = true;
//            size2[minIndex]=true;
//        }
//
//        for (int i = 0; i < size2.length; i++) {
//            if (!size2[i]) {
//                int min = Integer.MAX_VALUE;
//                for (int j = 0; j < cost.size(); j++) {
//                    min = Math.min(cost.get(j).get(i), min);
//                }
//                ans += min;
//                size2[i] = true;
//            }
//        }
//
//        return ans;
//    }

    class Solution {
        public int connectTwoGroups(List<List<Integer>> cost) {
            int size1 = cost.size(), size2 = cost.get(0).size(), m = 1 << size2;
            int[] dp1 = new int[m];
            Arrays.fill(dp1, Integer.MAX_VALUE / 2);
            int[] dp2 = new int[m];
            dp1[0] = 0;
            for (int i = 1; i <= size1; i++) {
                for (int s = 0; s < m; s++) {
                    dp2[s] = Integer.MAX_VALUE / 2;
                    for (int k = 0; k < size2; k++) {
                        if ((s & (1 << k)) == 0) {
                            continue;
                        }
                        dp2[s] = Math.min(dp2[s], dp2[s ^ (1 << k)] + cost.get(i - 1).get(k));
                        dp2[s] = Math.min(dp2[s], dp1[s] + cost.get(i - 1).get(k));
                        dp2[s] = Math.min(dp2[s], dp1[s ^ (1 << k)] + cost.get(i - 1).get(k));
                    }
                }
                System.arraycopy(dp2, 0, dp1, 0, m);
            }
            return dp1[m - 1];
        }
    }

}
