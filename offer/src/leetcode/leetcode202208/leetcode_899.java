package leetcode.leetcode202208;

import java.util.Arrays;

public class leetcode_899 {
    public static void main(String[] args) {
        String s="aabbb";
        int k=2;
        System.out.println(orderlyQueue(s,k));
    }
    public static String orderlyQueue(String s, int _k) {
        char[] cs = s.toCharArray();
        //k==1时使用最小表示法，也可以将s复制一份拼接在s后面，然后维持s.length()长度的窗口暴力比较得到所需值
        if (_k == 1) {
            int i = 0, j = 1, k = 0, n = cs.length;
            while (i < n && j < n && k < n) {
                char a = cs[(i + k) % n], b = cs[(j + k) % n];
                if (a == b) k++;
                else {
                    if (a > b) i += k + 1;
                    else j += k + 1;
                    if (i == j) i++;
                    k = 0;
                }
            }
            i = Math.min(i, j);
            return s.substring(i) + s.substring(0, i);
        }
        //k>1时可以构造出任意排序方案
        else {
            Arrays.sort(cs);
            return String.valueOf(cs);
        }
    }
}
