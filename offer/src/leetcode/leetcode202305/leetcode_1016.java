package leetcode.leetcode202305;

import java.util.*;

public class leetcode_1016 {
    public boolean queryString(String s, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = n; i > 0; i--) {
            if (!set.contains(i)) {
                String binaryString = Integer.toBinaryString(i);
                if (!s.contains(binaryString)) {
                    return false;
                }
                int p = i;
                while (p > 0 && !set.contains(p) && (i % p) == 0) {
                    set.add(p--);
                }
            }
        }
        return true;
    }

    class Solution {
        public boolean queryString(String s, int n) {
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            int k = 1;
            while (k <= n) { // 遍历[1, n]的每个数的二进制;
                if (!s.contains(sb)) return false;
                ++k;
                strPlusOne(sb);
            }
            return true;
        }
        // 让二进制字符串 + 1;
        public void strPlusOne(StringBuilder sb) {
            int carry = 1;
            for (int i = sb.length() - 1; i >= 0 && carry != 0; --i) {
                carry += sb.charAt(i) - '0';
                sb.setCharAt(i, (char)(carry % 2 + '0'));
                carry /= 2;
            }
            if (carry != 0) {
                sb.insert(0, 1);
            }
        }
    }
}
