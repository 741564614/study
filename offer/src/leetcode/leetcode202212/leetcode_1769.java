package leetcode.leetcode202212;

public class leetcode_1769 {
    public int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        int n = boxes.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == '1') {
                for (int j = 0; j < n; j++) {
                    ans[j] += Math.abs(j - i);
                }
            }
        }
        return ans;
    }
}
