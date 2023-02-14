package leetcode.leetcode202302;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1124 {

    public static void main(String[] args) {
        int[] hours = new int[]{11, 2, 4, 14, 2, 15, 7, 10, 1, 16, 9, 0, 2, 8, 4, 14, 6, 12, 2, 8, 6, 4, 14, 13, 7, 16, 14, 2, 3, 2, 8, 3, 12, 3, 3, 9, 14, 1, 5, 3, 12, 0, 15, 5, 0, 2, 3, 16, 7, 2, 1, 1, 4, 9, 0, 11, 9, 16, 15, 7, 0, 5, 6, 4, 12, 1, 1, 2, 13, 8, 3, 9, 12, 9, 3, 11, 4, 14, 7, 5, 16, 0, 11, 8, 8, 14, 1, 5, 0, 6, 5, 8, 10, 15, 9, 14, 16, 11, 1, 13};
        System.out.println(new leetcode_1124().longestWPI(hours));
    }

    public int longestWPI(int[] hours) {
        int[] work = new int[hours.length], less = new int[hours.length];
        if (hours[0] > 8) {
            work[0]++;
        } else {
            less[0]++;
        }
        for (int i = 1; i < hours.length; i++) {
            if (hours[i] > 8) {
                work[i] = work[i - 1] + 1;
                less[i] = less[i - 1];
            } else {
                work[i] = work[i - 1];
                less[i] = less[i - 1] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i; j < hours.length; j++) {
                int curWork = work[j] - work[i], curLess = less[j] - less[i];
                if (hours[i] > 8) {
                    curWork++;
                } else {
                    curLess++;
                }
                if (curWork > curLess) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    public int longestWPI02(int[] hours) {
        int s = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                ans++;
            } else if (map.containsKey(s - 1)) {
                ans = Math.max(ans, i - map.get(s - 1) + 1);
            }
            map.putIfAbsent(s, i);
        }
        return ans;
    }

}
