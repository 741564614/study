package leetcode.leetcode202305;

public class leetcode_2437 {
    public int countTime(String time) {
        String[] split = time.split(":");
        int h, m;
        if (split[0].charAt(0) == '?' && split[0].charAt(1) == '?') {
            h = 24;
        } else if (split[0].charAt(0) == '?' && split[0].charAt(1) != '?') {
            h = split[0].charAt(1) > '3' ? 2 : 3;
        } else if (split[0].charAt(0) != '?' && split[0].charAt(1) == '?') {
            h = split[0].charAt(0) == '2' ? 4 : 10;
        } else {
            h = 1;
        }

        if (split[1].charAt(0) == '?' && split[1].charAt(1) == '?') {
            m = 60;
        } else if (split[1].charAt(0) == '?' && split[1].charAt(1) != '?') {
            m = 6;
        } else if (split[1].charAt(0) != '?' && split[1].charAt(1) == '?') {
            m = 10;
        } else {
            m = 1;
        }

        return h * m;
    }


    class Solution {
        public int countTime(String time) {
            int countHour = 0;
            int countMinute = 0;
            for (int i = 0; i < 24; i++) {
                int hiHour = i / 10;
                int loHour = i % 10;
                if ((time.charAt(0) == '?' || time.charAt(0) == hiHour + '0') &&
                        (time.charAt(1) == '?' || time.charAt(1) == loHour + '0')) {
                    countHour++;
                }
            }
            for (int i = 0; i < 60; i++) {
                int hiMinute = i / 10;
                int loMinute = i % 10;
                if ((time.charAt(3) == '?' || time.charAt(3) == hiMinute + '0') &&
                        (time.charAt(4) == '?' || time.charAt(4) == loMinute + '0')) {
                    countMinute++;
                }
            }
            return countHour * countMinute;
        }
    }

}
