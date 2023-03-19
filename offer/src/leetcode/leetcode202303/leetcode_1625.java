package leetcode.leetcode202303;

import java.util.Arrays;

public class leetcode_1625 {
    public String findLexSmallestString02(String s, int a, int b) {
        String ans = s;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            s = s.substring(b) + s.substring(0, b);
            char[] cs = s.toCharArray();
            for (int q = 0; q < 10; q++) {
                for (int j = 1; j < n; j += 2) {
                    cs[j] = change(cs[j], a);
                }
                if ((b & 1) == 1) {
                    for (int p = 0; p < 10; p++) {
                        for (int k = 0; k < n; k += 2) {
                            cs[k] = change(cs[k], a);
                        }
                        s = String.valueOf(cs);
                        if (ans.compareTo(s) > 0) {
                            ans = s;
                        }
                    }
                } else {
                    s = String.valueOf(cs);
                    if (ans.compareTo(s) > 0) {
                        ans = s;
                    }
                }
            }
        }
        return ans;
    }

    public char change(char c, int a) {
        return (char) ((c - '0' + a) % 10 + '0');
    }


    public static void main(String[] args) {

    }
}
