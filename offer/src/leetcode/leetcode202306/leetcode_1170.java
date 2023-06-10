package leetcode.leetcode202306;

import java.util.Arrays;

public class leetcode_1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsF = new int[words.length];
        for (int i = 0; i < wordsF.length; i++) {
            wordsF[i] = f(words[i]);
        }
        Arrays.sort(wordsF);
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = binarySearch(wordsF, f(queries[i]));
        }
        return ans;
    }

    public int binarySearch(int[] wordsF, int target) {
        int l = 0, r = wordsF.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (wordsF[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return wordsF.length - l;
    }

    public int f(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i : cnt) {
            if (i > 0) {
                return i;
            }
        }
        return 0;
    }

    class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] count = new int[12];
            for (String s : words) {
                count[f(s)]++;
            }
            for (int i = 9; i >= 1; i--) {
                count[i] += count[i + 1];
            }
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                String s = queries[i];
                res[i] = count[f(s) + 1];
            }
            return res;
        }

        public int f(String s) {
            int cnt = 0;
            char ch = 'z';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < ch) {
                    ch = c;
                    cnt = 1;
                } else if (c == ch) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
