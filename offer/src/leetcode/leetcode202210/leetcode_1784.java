package leetcode.leetcode202210;

public class leetcode_1784 {
    public boolean checkOnesSegment(String s) {
        int st=0;
        while(st<s.length()&&s.charAt(st)=='1'){
            st++;
        }
        for (int i = st; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                return false;
            }
        }
        return true;
    }

    public boolean checkOnesSegment02(String s) {
        return !s.contains("01");
    }
}
