package leetcode.leetcode202301;

public class leetcode_2309 {
    public String greatestLetter(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean[] upper = new boolean[26];
        boolean[] lower = new boolean[26];
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper[c - 'A'] = true;
                if (lower[c - 'A']) {
                    if (stringBuffer.length() == 0) {
                        stringBuffer.append(c);
                    } else if (stringBuffer.charAt(0) > c) {
                        stringBuffer.deleteCharAt(0);
                        stringBuffer.append(c);
                    }
                }
            } else if (Character.isLowerCase(c)) {
                lower[c - 'a'] = true;
                if (upper[c - 'a']) {
                    if (stringBuffer.length() == 0) {
                        stringBuffer.append((char)(c - 'a' + 'A'));
                    } else if (stringBuffer.charAt(0) > (c - 'a' + 'A')) {
                        stringBuffer.deleteCharAt(0);
                        stringBuffer.append((char)(c - 'a' + 'A'));
                    }
                }
            }
        }
        return stringBuffer.toString();
    }


    public String greatestLetter02(String s) {
        char[] cl = s.toCharArray();
        for(char i = 'Z'; i >= 'A'; i--){
            if(s.indexOf(i) > -1 && s.indexOf(i+32) > -1){
                return String.valueOf(i);
            }
        }
        return "";
    }
}
