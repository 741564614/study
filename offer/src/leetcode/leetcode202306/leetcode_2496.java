package leetcode.leetcode202306;

public class leetcode_2496 {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for (String str : strs) {
            ans = Math.max(ans, getValue(str));
        }
        return ans;
    }

    public int getValue(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return str.length();
            }
        }
        return Integer.parseInt(str);
    }
}
