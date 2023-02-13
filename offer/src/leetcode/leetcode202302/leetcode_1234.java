package leetcode.leetcode202302;

import java.util.*;

public class leetcode_1234 {

    public static void main(String[] args) {
        System.out.println(new leetcode_1234().balancedString("WQWRQQQW"));
    }

    public int balancedString(String s) {
        int n = s.length();
        char[] chars = new char[]{'Q', 'W', 'E', 'R'};
        int[] target = new int[4];
        for (char c : s.toCharArray()) {
            for (int i = 0; i < chars.length; i++) {
                if (c == chars[i]) {
                    target[i]++;
                    break;
                }
            }
        }
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            if (target[i] > n / 4) {
                targetMap.put(chars[i], target[i] - n / 4);
            }
        }
        if (targetMap.isEmpty()) {
            return 0;
        }
        int ans = n;
        int i = 0, j = 0;
        while (j < n) {
            char a = s.charAt(j++);
            windows.put(a, windows.getOrDefault(a, 0) + 1);

            while (i < j && check(targetMap, windows)) {
                ans = Math.min(ans, j - i);
                char b = s.charAt(i++);
                windows.put(b, windows.getOrDefault(b, 0) - 1);
            }
        }
        return ans;
    }

    public boolean check(Map<Character, Integer> targetMap, Map<Character, Integer> windows) {
        boolean ans = true;
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            ans = ans && (windows.getOrDefault(entry.getKey(), 0) >= entry.getValue());
        }
        return ans;
    }

    class Solution {
        public int balancedString02(String s) {
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cnt[idx(c)]++;
            }

            int partial = s.length() / 4;
            int res = s.length();

            if (check(cnt, partial)) {
                return 0;
            }
            for (int l = 0, r = 0; l < s.length(); l++) {
                while (r < s.length() && !check(cnt, partial)) {
                    cnt[idx(s.charAt(r))]--;
                    r++;
                }
                if (!check(cnt, partial)) {
                    break;
                }
                res = Math.min(res, r - l);
                cnt[idx(s.charAt(l))]++;
            }
            return res;
        }

        public int idx(char c) {
            return c - 'A';
        }

        public boolean check(int[] cnt, int partial) {
            if (cnt[idx('Q')] > partial || cnt[idx('W')] > partial || cnt[idx('E')] > partial || cnt[idx('R')] > partial) {
                return false;
            }
            return true;
        }
    }

}
