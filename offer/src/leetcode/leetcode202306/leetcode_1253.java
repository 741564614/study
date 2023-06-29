package leetcode.leetcode202306;

import java.util.*;

public class leetcode_1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int i = 0; i < colsum.length; i++) {
            if (upper == 0 && lower == 0 && colsum[i] != 0) {
                return new ArrayList<>();
            }
            if (colsum[i] == 2) {
                if (upper > 0 && lower > 0) {
                    ans.get(0).add(1);
                    ans.get(1).add(1);
                    upper--;
                    lower--;
                } else {
                    return new ArrayList<>();
                }
            } else if (colsum[i] == 1) {
                if (upper >= lower && upper > 0) {
                    ans.get(0).add(1);
                    upper--;
                } else if (lower > upper && lower > 0) {
                    ans.get(1).add(1);
                    lower--;
                } else {
                    return new ArrayList<>();
                }
            } else {
                ans.get(0).add(0);
                ans.get(1).add(0);
            }
        }
        return upper == 0 && lower == 0 ? ans : new ArrayList<>();
    }
}
