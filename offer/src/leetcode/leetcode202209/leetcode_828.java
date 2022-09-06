package leetcode.leetcode202209;

import java.util.Arrays;

public class leetcode_828 {
    public static void main(String[] args) {

    }

    public int uniqueLetterString02(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] index = new int[26], l = new int[n], r = new int[n];
        Arrays.fill(index, -1);
        for (int i = 0; i < chars.length; i++) {
            int k = chars[i] - 'A';
            l[i] = index[k];
            index[k] = i;
        }

        Arrays.fill(index, n);
        for (int i = n - 1; i >= 0; i--) {
            int k = chars[i] - 'A';
            r[i] = index[k];
            index[k] = i;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (i - l[i]) * (r[i] - i);
        }
        return ans;
    }
}
