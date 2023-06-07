package leetcode.leetcode202306;

import java.util.*;

public class leetcode_2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        List<Integer> list = new ArrayList<>();
        int n = reward1.length;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        list.sort(Comparator.comparingInt(a -> reward2[a] - reward1[a]));
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += reward1[list.get(i)];
        }
        for (int i = k; i < n; i++) {
            ans += reward2[list.get(i)];
        }
        return ans;
    }

    class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            int ans = 0;
            int n = reward1.length;
            int[] diffs = new int[n];
            for (int i = 0; i < n; i++) {
                ans += reward2[i];
                diffs[i] = reward1[i] - reward2[i];
            }
            Arrays.sort(diffs);
            for (int i = 1; i <= k; i++) {
                ans += diffs[n - i];
            }
            return ans;
        }
    }

}
