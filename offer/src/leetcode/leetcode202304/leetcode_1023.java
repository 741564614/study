package leetcode.leetcode202304;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode_1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            ans.add(match(query, pattern));
        }
        return ans;
    }

    public boolean match(String s, String pattern) {
        int index = 0, prev = 0;
        for (; prev < s.length() && index < pattern.length(); prev++) {
            int next = s.indexOf(pattern.charAt(index++), prev);
            if (next == -1) {
                return false;
            }
            while (prev < next) {
                if (Character.isUpperCase(s.charAt(prev++))) {
                    return false;
                }
            }
        }
        while (prev < s.length()) {
            if (Character.isUpperCase(s.charAt(prev++))) {
                return false;
            }
        }
        return true;
    }

    public List<Boolean> camelMatch02(String[] queries, String pattern) {
        StringBuilder regexp = new StringBuilder("[a-z]*");
        for (int i = 0; i < pattern.length(); i++) {
            regexp.append(pattern.charAt(i)).append("[a-z]*");
        }
        return Arrays.stream(queries).map(query->query.matches(regexp.toString())).collect(Collectors.toList());
    }
}
