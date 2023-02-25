package leetcode.leetcode202302;

public class leetcode_1247 {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            if (s1Chars[i] != s2Chars[i]) {
                count[s1Chars[i] - 'x']++;
            }
        }
        return (count[0] + count[1]) % 2 != 0 ? -1 : count[0] / 2 + count[1] / 2 + count[0] % 2 + count[1] % 2;
    }
}
