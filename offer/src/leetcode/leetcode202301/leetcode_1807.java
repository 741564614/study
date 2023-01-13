package leetcode.leetcode202301;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size());
        knowledge.forEach(i -> map.put(i.get(0), i.get(1)));
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(') {
                int start = ++i;
                while (s.charAt(i) != ')') {
                    i++;
                }
                stringBuffer.append(map.getOrDefault(s.substring(start, i), "?"));
            } else {
                stringBuffer.append(a);
            }
        }
        return stringBuffer.toString();
    }
}
