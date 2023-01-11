package leetcode.leetcode202301;

public class leetcode_2283 {
    public boolean digitCount(String num) {
        int[] counts = new int[10];
        int n = num.length();
        for (int i = 0; i < n; i++) {
            counts[num.charAt(i)-'0']++;
        }
        for (int i = 0; i < n; i++) {
            int time = num.charAt(i)-'0';
            if (counts[i]!=time){
                return false;
            }
        }
        return true;
    }
}
