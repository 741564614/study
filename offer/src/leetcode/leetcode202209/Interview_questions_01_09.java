package leetcode.leetcode202209;

public class Interview_questions_01_09 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String k = s1 + s1;
        return k.contains(s2);
    }
}
