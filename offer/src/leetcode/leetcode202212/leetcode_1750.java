package leetcode.leetcode202212;

public class leetcode_1750 {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r && chars[l] == chars[r]) {
            char a = chars[l];
            while (l <= r && chars[l] == a) {
                l++;
            }
            while (l <= r && chars[r] == a) {
                r--;
            }
        }

        return r - l + 1;
    }
}
