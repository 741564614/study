package leetcode.leetcode202209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class leetcode_1592 {
    public static void main(String[] args) {
        String text = "  this   is  a sentence ";
        System.out.println(reorderSpaces(text));
    }

    public static String reorderSpaces(String text) {
        int sum = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                sum++;
            }
        }
        List<String> collect = Arrays.stream(text.split(" ")).filter(i -> null != i && i.length() > 0).collect(Collectors.toList());
        int k = sum / Math.max(1, (collect.size() - 1));
        int j = sum % Math.max(1, (collect.size() - 1));
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < collect.size(); i++) {
            stringBuffer.append(collect.get(i));
            for (int l = 0; l < (i != collect.size() - 1 || collect.size() == 1 ? k : j); l++) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public String reorderSpaces02(String s) {
        int n = s.length(), cnt = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ' && ++i >= 0 && ++cnt >= 0) continue;
            int j = i;
            while (j < n && s.charAt(j) != ' ') j++;
            list.add(s.substring(i, j));
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        int m = list.size(), t = cnt / Math.max(m - 1, 1);
        String k = "";
        while (t-- > 0) k += " ";
        for (int i = 0; i < m; i++) {
            sb.append(list.get(i));
            if (i != m - 1) sb.append(k);
        }
        while (sb.length() != n) sb.append(" ");
        return sb.toString();
    }
}
