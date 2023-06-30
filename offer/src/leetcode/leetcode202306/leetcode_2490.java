package leetcode.leetcode202306;

public class leetcode_2490 {
    public static void main(String[] args) {
        System.out.println(new leetcode_2490().isCircularSentence("leetcode exercises sound delightful"));
    }
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].charAt(s[i].length() - 1) != s[(i + 1) % s.length].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
