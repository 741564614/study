package leetcode.leetcode202303;

import java.util.*;

public class Interview_questions_17_05 {
    public String[] findLongestSubarray(String[] array) {
        int charPrefix = 0, numPrefix = 0, ans = 0, l = 0, r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //最开始为0
        map.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                numPrefix++;
            } else {
                charPrefix++;
            }
            int gap = charPrefix - numPrefix;
            map.putIfAbsent(gap, i);
            if (gap != 0 || map.get(gap) != i) {
                if (i - map.get(gap) > ans) {
                    ans = i - map.get(gap);
                    l = map.get(gap) + 1;
                    r = i + 1;
                }
            }
        }
        return ans == 0 ? new String[0] : Arrays.copyOfRange(array, l, r);
    }
}
