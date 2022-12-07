package leetcode.leetcode202212;

import java.util.HashSet;
import java.util.Set;

public class leetcode_1805 {
    public int numDifferentIntegers(String word) {
        Set<String> ans = new HashSet<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                StringBuffer stringBuffer = new StringBuffer();
                while (i < chars.length &&Character.isDigit(chars[i])) {
                    if (stringBuffer.length() == 1 && stringBuffer.charAt(0) == '0') {
                        stringBuffer.deleteCharAt(0);
                    }
                    stringBuffer.append(chars[i++]);
                }
                ans.add(stringBuffer.toString());
            }
        }
        return ans.size();
    }
}
