package leetcode.leetcode202308;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode_722 {
    public static void main(String[] args) {
        String[] s = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        System.out.println(new leetcode_722().removeComments(s));
    }

    public List<String> removeComments(String[] source) {
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            sb.append(s).append("\n");
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '/' && sb.charAt(i + 1) == '*') {
                sb.delete(i, sb.indexOf("*/", i + 2) + 2);
                i--;
            } else if (sb.charAt(i) == '/' && sb.charAt(i + 1) == '/') {
                sb.delete(i, sb.indexOf("\n", i + 2));
                i--;
            }
        }
        return Arrays.stream(sb.toString().split("\n")).filter(a -> a.length() > 0).collect(Collectors.toList());
    }
}
