package leetcode.leetcode202305;

import java.util.Arrays;

public class leetcode_2451 {
    public String oddString(String[] words) {
        int n = words[0].length();
        int[][] diff = new int[words.length][n - 1];
        for (int i = 0; i < words.length; i++) {
            change(words[i], diff[i]);
        }
        for (int i = 0; i < words.length - 2; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (diff[i][j] != diff[i + 1][j] && diff[i][j] != diff[i + 2][j]) {
                    return words[i];
                }
                if (diff[i][j] != diff[i + 1][j] && diff[i + 1][j] != diff[i + 2][j]) {
                    return words[i + 1];
                }
                if (diff[i][j] != diff[i + 2][j] && diff[i + 1][j] != diff[i + 2][j]) {
                    return words[i + 2];
                }
            }
        }
        return words[0];
    }

    public void change(String word, int[] ans) {
        int base = word.charAt(0) - 'a';
        for (int i = 1; i < word.length(); i++) {
            ans[i - 1] = word.charAt(i) - 'a' - base;
        }
    }


    class Solution {
        public String oddString(String[] words) {
            int[] diff0 = get(words[0]);
            int[] diff1 = get(words[1]);
            if (Arrays.equals(diff0, diff1)) {
                for (int i = 2; i < words.length; i++) {
                    if (!Arrays.equals(diff0, get(words[i]))) {
                        return words[i];
                    }
                }
            }
            return Arrays.equals(diff0, get(words[2])) ? words[1] : words[0];
        }

        public int[] get(String word) {
            int[] diff = new int[word.length() - 1];
            for (int i = 0; i + 1 < word.length(); i++) {
                diff[i] = word.charAt(i + 1) - word.charAt(i);
            }
            return diff;
        }
    }

}
