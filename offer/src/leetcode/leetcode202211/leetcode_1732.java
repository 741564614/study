package leetcode.leetcode202211;

public class leetcode_1732 {
    public int largestAltitude(int[] gain) {
        int max=0,nowGain=0;
        for (int i : gain) {
            nowGain+=i;
            max=Math.max(max,nowGain);
        }
        return max;
    }
}
