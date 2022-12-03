package leetcode.leetcode202212;

public class leetcode_1796 {
    public static void main(String[] args) {
        System.out.println(new leetcode_1796().secondHighest("abc1111"));
    }

    public int secondHighest(String s) {
        int max = -1, max2 = -1;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (c - '0' > max) {
                    max2 = max;
                    max = (c - '0');
                } else if (c - '0' > max2 && (c - '0') != max) {
                    max2 = (c - '0');
                }
            }
        }
        return max2;
    }
}
