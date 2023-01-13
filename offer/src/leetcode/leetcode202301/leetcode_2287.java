package leetcode.leetcode202301;

public class leetcode_2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] sChars = new int[26], tChars = new int[26];
        for (char c : s.toCharArray()) {
            sChars[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            tChars[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < tChars.length; i++) {
            if (tChars[i] > sChars[i]) {
                return 0;
            } else if (tChars[i] != 0) {
                ans = Math.min(ans, sChars[i] / tChars[i]);
            }
        }
        return ans;
    }
}
