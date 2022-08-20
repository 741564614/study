package leetcode.leetcode202208;

import java.util.ArrayList;
import java.util.List;

public class leetcode_761 {
    public static void main(String[] args) {
        String s = "11110000";
        System.out.println(makeLargestSpecial2(s));
    }

    public static String makeLargestSpecial2(String s) {
        if (s.length() == 0) return s;
        List<String> list = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0, j = 0, k = 0; i < cs.length; i++) {
            k += cs[i] == '1' ? 1 : -1;
            if (k == 0) {
                list.add("1" + makeLargestSpecial2(s.substring(j + 1, i)) + "0");
                j = i + 1;
            }
        }
        list.sort((a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String str : list) sb.append(str);
        return sb.toString();
    }
}
