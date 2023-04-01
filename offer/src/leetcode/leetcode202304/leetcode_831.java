package leetcode.leetcode202304;

public class leetcode_831 {
    public String maskPII(String s) {
        if (s.contains("@")) {
            return maskMail(s);
        }
        return maskPhone(s);
    }

    public String maskMail(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = s.toLowerCase().split("@");
        stringBuilder.append(split[0].charAt(0)).append("*****").append(split[0].charAt(split[0].length() - 1));
        stringBuilder.append("@").append(split[1]);
        return stringBuilder.toString();
    }

    public String maskPhone(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int count = -10;
        for (int i = s.length() - 1; i >= 0; i--) {
            char a = s.charAt(i);
            if (Character.isDigit(a)) {
                if (count < -6) {
                    sb.append(a);
                }
                count++;
            }
        }
        if (count == 0) {
            stringBuilder.append("***-***-");
        } else if (count == 1) {
            stringBuilder.append("+*-***-***-");
        } else if (count == 2) {
            stringBuilder.append("+**-***-***-");
        } else {
            stringBuilder.append("+***-***-***-");
        }
        stringBuilder.append(sb.reverse());
        return stringBuilder.toString();
    }

    class Solution {
        String[] country = {"", "+*-", "+**-", "+***-"};

        public String maskPII(String s) {
            int at = s.indexOf("@");
            if (at > 0) {
                s = s.toLowerCase();
                return (s.charAt(0) + "*****" + s.substring(at - 1)).toLowerCase();
            }
            s = s.replaceAll("[^0-9]", "");
            return country[s.length() - 10] + "***-***-" + s.substring(s.length() - 4);
        }
    }

}
