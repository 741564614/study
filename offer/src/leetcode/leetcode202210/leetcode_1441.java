package leetcode.leetcode202210;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0, k = 1; i < target.length; k++) {
            ans.add("Push");
            if (target[i] != k) {
                ans.add("Pop");
            } else {
                i++;
            }
        }
        return ans;
    }
}
