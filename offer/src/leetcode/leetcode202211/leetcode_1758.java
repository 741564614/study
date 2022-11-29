package leetcode.leetcode202211;

public class leetcode_1758 {
    public static void main(String[] args) {
        String s = "10010100";
        System.out.println(new leetcode_1758().minOperations(s));
    }

    public int minOperations(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] - '0') != (i % 2)) {
                ans++;
            }
        }
        return Math.min(ans, s.length() - ans);
    }
}
