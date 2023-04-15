package leetcode.leetcode202304;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        List<Integer>[] garden = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            garden[i] = new ArrayList<>();
        }
        for (int i = 0; i < paths.length; i++) {
            int x = paths[i][0]-1, y = paths[i][1]-1;
            garden[x].add(y);
            garden[y].add(x);
        }

        for (int i = 0; i < garden.length; i++) {
            ans[i] = colors(garden[i], ans);
        }
        return ans;
    }

    public int colors(List<Integer> garden, int[] ans) {
        boolean[] check = new boolean[4];
        for (Integer point : garden) {
            if (ans[point] != 0) {
                check[ans[point] - 1] = true;
            }
        }
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                return i + 1;
            }
        }
        return 0;
    }
}
