package leetcode.leetcode202306;

import java.util.*;

public class leetcode_2352 {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> row = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                stringBuilder.append(grid[i][j]).append(",");
            }
            row.put(stringBuilder.toString(), row.getOrDefault(stringBuilder.toString(), 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                stringBuilder.append(grid[j][i]).append(",");
            }
            ans += row.getOrDefault(stringBuilder.toString(), 0);
        }
        return ans;
    }

    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            Map<List<Integer>, Integer> cnt = new HashMap<List<Integer>, Integer>();
            for (int[] row : grid) {
                List<Integer> arr = new ArrayList<Integer>();
                for (int num : row) {
                    arr.add(num);
                }
                cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
            }

            int res = 0;
            for (int j = 0; j < n; j++) {
                List<Integer> arr = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    arr.add(grid[i][j]);
                }
                if (cnt.containsKey(arr)) {
                    res += cnt.get(arr);
                }
            }
            return res;
        }
    }

}
