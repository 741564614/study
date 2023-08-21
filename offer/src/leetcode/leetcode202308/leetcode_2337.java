package leetcode.leetcode202308;

public class leetcode_2337 {
    public static void main(String[] args) {
        System.out.println(new leetcode_2337().canChange("_L__R____", "L______RR"));
    }

    public boolean canChange(String start, String target) {
        int n = start.length();
        int sindex = 0, tindex = 0;
        while (sindex < n && tindex < n) {
            while (tindex < n && target.charAt(tindex) == '_') {
                tindex++;
            }
            while (sindex < n && start.charAt(sindex) == '_') {
                sindex++;
            }
            if (sindex < n && tindex < n) {
                char s = start.charAt(sindex), t = target.charAt(tindex);
                if (s != t || (s == 'L' && sindex < tindex) || (s == 'R' && sindex > tindex)) {
                    return false;
                }
            }
            sindex++;
            tindex++;
        }
        while (tindex < n && target.charAt(tindex) == '_') {
            tindex++;
        }
        while (sindex < n && start.charAt(sindex) == '_') {
            sindex++;
        }
        return sindex == tindex;
    }
}
