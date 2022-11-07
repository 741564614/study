package leetcode.leetcode202211;

import java.util.ArrayList;
import java.util.List;

public class leetcode_816 {
    public List<String> ambiguousCoordinates02(String s) {
        s = s.substring(1, s.length() - 1);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            List<String> a = search(0, i, s);
            List<String> b = search(i + 1, s.length() - 1, s);
            for (String s1 : a) {
                for (String s2 : b) {
                    ans.add("(" + s1 + ", " + s2 + ")");
                }
            }
        }
        return ans;
    }

    public List<String> search(int start, int end, String s) {
        List<String> ans = new ArrayList<>();
        if (start == end || s.charAt(start) != '0') {
            ans.add(s.substring(start, end + 1));
        }
        for (int i = start; i < end; i++) {
            String a = s.substring(start, i + 1);
            String b = s.substring(i + 1, end + 1);
            if (a.length() > 1 && a.charAt(0) == '0') {
                continue;
            }
            if (b.charAt(b.length() - 1) == '0') {
                continue;
            }
            ans.add(a + "." + b);
        }
        return ans;
    }
}
