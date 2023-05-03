package leetcode.leetcode202305;

public class leetcode_1003 {
    public boolean isValid(String s) {
        char[] pattern = new char[]{'a', 'b', 'c'};
        int prev = 0;
        while (prev != s.length()) {
            prev = s.length();
            s = s.replace("abc", "");
        }
        return s.length() == 0;
    }

    class Solution {
        public boolean isValid(String s) {
            StringBuilder stk = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                stk.append(c);
                if (stk.length() >= 3 && stk.substring(stk.length() - 3).equals("abc")) {
                    stk.delete(stk.length() - 3, stk.length());
                }
            }
            return stk.length() == 0;
        }
    }

}
