package leetcode.leetcode202212;

public class leetcode_1812 {
    public boolean squareIsWhite(String coordinates) {
        int a=coordinates.charAt(0)-'a'+1;
        int b=coordinates.charAt(1)-'0';
        return a%2!=b%2;
    }
}
