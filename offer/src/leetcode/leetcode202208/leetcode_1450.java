package leetcode.leetcode202208;

public class leetcode_1450 {
    public static void main(String[] args) {

    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }
}
