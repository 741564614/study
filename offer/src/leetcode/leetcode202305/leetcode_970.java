package leetcode.leetcode202305;

import java.util.*;

public class leetcode_970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int xLimit = getMax(x, bound);
        int yLimit = getMax(y, bound);
        int[] xm = new int[xLimit + 1];
        int[] ym = new int[yLimit + 1];
        xm[0] = ym[0] = 1;
        for (int i = 1; i <= Math.max(xLimit, yLimit); i++) {
            if (i <= xLimit) {
                xm[i] = xm[i - 1] * x;
            }
            if (i <= yLimit) {
                ym[i] = ym[i - 1] * y;
            }
        }
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i <= xLimit; i++) {
            for (int j = 0; j <= yLimit; j++) {
                int num = xm[i] + ym[j];
                if (num <= bound) {
                    ans.add(num);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public int getMax(int base, int limit) {
        if (limit == 0) {
            return 0;
        }
        if (base == 1) {
            return 1;
        }
        int ans = 0;
        while (limit > 0) {
            limit /= base;
            ans++;
        }
        return ans;
    }


    class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> set = new HashSet<>();
            //达到log(x)(bound)的效果
            int m = x == 1 ? 0 : (int) (Math.log10(bound) / Math.log10(x));
            int n = y == 1 ? 0 : (int) (Math.log10(bound) / Math.log10(y));
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    int cur = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                    if (cur <= bound) {
                        set.add(cur);
                    }
                }
            }

            return new ArrayList<>(set);
        }
    }
}
