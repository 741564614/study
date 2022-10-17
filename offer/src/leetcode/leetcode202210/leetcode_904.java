package leetcode.leetcode202210;

import java.util.HashMap;
import java.util.Map;

public class leetcode_904 {
    public int totalFruit(int[] fruits) {
        int max = 0;
        int l = 0, r = 0;
        int temp = 0;
        int types = 0;
        int[] type = new int[fruits.length];
        while (r < fruits.length) {
            if (type[fruits[r]] == 0) {
                types++;
            }
            temp++;
            type[fruits[r]]++;
            while (types > 2) {
                type[fruits[l]]--;
                if (type[fruits[l]] == 0) {
                    types--;
                }
                temp--;
                l++;
            }
            max = Math.max(max, temp);
            r++;
        }
        return max;
    }

    public int totalFruit02(int[] fs) {
        int n = fs.length, ans = 0;
        int[] cnts = new int[n + 10];
        for (int i = 0, j = 0, tot = 0; i < n; i++) {
            if (++cnts[fs[i]] == 1) tot++;
            while (tot > 2) {
                if (--cnts[fs[j++]] == 0) tot--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
