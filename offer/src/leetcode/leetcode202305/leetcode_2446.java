package leetcode.leetcode202305;

public class leetcode_2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        return (event1[0].compareTo(event2[0]) <= 0 && event1[1].compareTo(event2[0]) >= 0) ||
                (event1[0].compareTo(event2[1]) <= 0 && event1[1].compareTo(event2[1]) >= 0) ||
                (event1[0].compareTo(event2[0]) <= 0 && event1[1].compareTo(event2[0]) >= 0) ||
                (event2[0].compareTo(event1[1]) <= 0 && event2[1].compareTo(event1[1]) >= 0);
    }

    class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
        }
    }

}
