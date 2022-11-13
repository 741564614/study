package leetcode.leetcode202211;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_791 {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (char c : order.toCharArray()) {
            Integer n = map.getOrDefault(c, 0);
            for (int i = 0; i < n; i++) {
                stringBuffer.append(c);
            }
            map.remove(c);
        }

        map.forEach((k,v)->{
            for (int i = 0; i < v; i++) {
                stringBuffer.append(k);
            }
        });

        return stringBuffer.toString();
    }

    public String customSortString02(String order, String s) {
        char[] chars = new char[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (char c : order.toCharArray()) {
            for (int i = 0; i < chars[c - 'a']; i++) {
                stringBuffer.append(c);
            }
            chars[c-'a']=0;
        }

        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < chars[i - 'a']; j++) {
                stringBuffer.append(i);
            }
        }

        return stringBuffer.toString();
    }
}
