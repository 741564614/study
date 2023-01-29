package leetcode.leetcode202301;

public class leetcode_2315 {
    public int countAsterisks(String s) {
        String[] split = s.split("\\|");
        int ans = 0;
        for (int i = 0; i < split.length; i += 2) {
            for (char c : split[i].toCharArray()) {
                if (c == '*') {
                    ans++;
                }
            }
        }

        return ans;
    }
}
