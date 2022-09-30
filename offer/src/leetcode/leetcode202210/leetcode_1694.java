package leetcode.leetcode202210;

public class leetcode_1694 {
    public static void main(String[] args) {
        String k="1-23-45 6";
        System.out.println(reformatNumber(k));
    }
    public static String reformatNumber(String number) {
        number = number.replace("-", "").replace(" ", "");
        if (number.length() <= 2) {
            return number;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (number.length() > 4) {
            stringBuffer.append(number, 0, 3);
            stringBuffer.append('-');
            number = number.substring(3);
        }
        if (number.length() == 4) {
            stringBuffer.append(number, 0, 2);
            stringBuffer.append('-');
            stringBuffer.append(number, 2, 4);
        } else {
            stringBuffer.append(number);
        }
        return stringBuffer.toString();
    }
}
