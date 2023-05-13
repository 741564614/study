package leetcode.leetcode202305;

import java.util.*;

public class leetcode_2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = -1;
        for (int num : nums) {
            if (num > 0 && num > ans && set.contains(-num)) {
                ans = num;
            }
        }
        return ans;
    }

    public int findMaxK20(int[] nums) {
        boolean[] check = new boolean[2001];
        for (int num : nums) {
            check[num + 1000] = true;
        }
        int ans = -1;
        for (int num : nums) {
            if (num > 0 && num > ans && check[1000 - num]) {
                ans = num;
            }
        }
        return ans;
    }
}
