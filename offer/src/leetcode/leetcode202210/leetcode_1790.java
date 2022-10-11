package leetcode.leetcode202210;

public class leetcode_1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] check = new int[26];
        int d = 0, n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                d++;
                check[s1.charAt(i) - 'a']++;
                check[s2.charAt(i) - 'a']--;
            }
            if (d > 2) {
                return false;
            }
        }
        for (int i : check) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
