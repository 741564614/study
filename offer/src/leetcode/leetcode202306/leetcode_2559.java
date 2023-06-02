package leetcode.leetcode202306;

import java.util.HashSet;
import java.util.Set;

public class leetcode_2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + (check(words[i - 1].charAt(0)) && check(words[i - 1].charAt(words[i - 1].length() - 1)) ? 1 : 0);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        return ans;
    }

    public boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
    }

}
