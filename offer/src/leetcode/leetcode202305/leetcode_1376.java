package leetcode.leetcode202305;

import java.util.*;
import java.util.List;

public class leetcode_1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer>[] branch = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            if (i != headID) {
                if (branch[manager[i]] == null) {
                    branch[manager[i]] = new ArrayList<>();
                }
                branch[manager[i]].add(i);
            }
        }
        return dfs(headID, branch, informTime);
    }

    public int dfs(int headId, ArrayList<Integer>[] branch, int[] informTime) {
        if (branch[headId] == null || branch[headId].size() == 0) {
            return informTime[headId];
        }
        int max = 0;
        for (Integer next : branch[headId]) {
            max = Math.max(dfs(next, branch, informTime), max);
        }
        return max + informTime[headId];
    }
}
