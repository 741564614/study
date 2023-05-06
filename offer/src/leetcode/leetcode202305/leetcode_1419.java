package leetcode.leetcode202305;

import java.util.*;

public class leetcode_1419 {

    public static void main(String[] args) {
        System.out.println(new leetcode_1419().minNumberOfFrogs("crcoakroak"));
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] frogs = new int[5];
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);
        for (char c : croakOfFrogs.toCharArray()) {
            if (!map.containsKey(c)) {
                return -1;
            }
            Integer value = map.get(c);
            if (value == 0) {
                if (frogs[4] != 0) {
                    frogs[4]--;
                }
                frogs[0]++;
            } else {
                if (frogs[value - 1] == 0) {
                    return -1;
                }
                frogs[value - 1]--;
                frogs[value]++;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (frogs[i] > 0) {
                return -1;
            }
        }
        return frogs[4];
    }

    // https://space.bilibili.com/206214
    static class Solution {
        // 's' 保证 "croak" 中的任意字符不会越界
        private static final char[] PREV = new char['s'];

        static {
            var s = "croakc".toCharArray();
            for (int i = 1; i < s.length; i++)
                PREV[s[i]] = s[i - 1];
        }

        public int minNumberOfFrogs(String croakOfFrogs) {
            if (croakOfFrogs.length() % 5 > 0) return -1;
            var s = croakOfFrogs.toCharArray();
            var cnt = new int['s'];
            for (var c : s) {
                var p = PREV[c];
                if (cnt[p] > 0) cnt[p]--;
                else if (c != 'c') return -1;
                cnt[c]++;
            }
            if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0)
                return -1;
            return cnt['k'];
        }
    }

}
