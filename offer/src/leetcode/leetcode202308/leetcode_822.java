package leetcode.leetcode202308;

import java.util.*;

public class leetcode_822 {
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        int[] repeat = new int[2001];
        boolean[] check = new boolean[2001];
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                repeat[fronts[i]]++;
            }
            check[fronts[i]] = true;
            check[backs[i]] = true;
        }
        for (int i = 1; i < 2001; i++) {
            if (check[i] && repeat[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}
