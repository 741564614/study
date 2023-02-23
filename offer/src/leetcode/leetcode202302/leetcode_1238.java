package leetcode.leetcode202302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class leetcode_1238 {
    public static void main(String[] args) {
        System.out.println(new leetcode_1238().circularPermutation(2, 3));
    }

    public List<Integer> circularPermutation(int n, int start) {
        int len = 1 << n;
        boolean[] check = new boolean[len];
        Integer[] ans = new Integer[len];
        ans[0] = start;
        check[start] = true;
        ans[len - 1] = move(start, check, n);
        for (int i = 1; i < len - 1; i++) {
            ans[i] = move(ans[i - 1], check, n);
        }
        return Arrays.stream(ans).collect(Collectors.toList());
    }

    public int move(int start, boolean[] check, int n) {
        for (int i = n - 1; i >= 0; i--) {
            int next = start ^ (1 << i);
            if (!check[next]) {
                check[next] = true;
                return next;
            }
        }
        return -1;
    }


    public List<Integer> circularPermutation02(int n, int start) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(start);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(((ret.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return ret;
    }
}
