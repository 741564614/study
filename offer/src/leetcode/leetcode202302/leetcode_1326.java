package leetcode.leetcode202302;

import java.util.*;

public class leetcode_1326 {
    public static void main(String[] args) {
        int[] ranges = new int[]{3, 3, 1, 1, 0, 1};
        System.out.println(new leetcode_1326().minTaps(5, ranges));
    }

    public int minTaps(int n, int[] ranges) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            if (ranges[i] != 0) {
                index.add(i);
            }
        }
        index.sort((a, b) -> {
            int la = Math.max(a - ranges[a], 0), lb = Math.max(b - ranges[b], 0);
            if (la == lb) {
                return b + ranges[b] - a - ranges[a];
            }
            return la - lb;
        });

        if (index.size() == 0) {
            return -1;
        }

        int first = index.get(0);
        int left = first - ranges[first], right = first + ranges[first], ans = 1;
        for (int i = 1; i < index.size() && right < n; i++) {
            int next = i, maxRight = right;
            while (next < index.size() && index.get(next) - ranges[index.get(next)] <= right) {
                if (index.get(next) + ranges[index.get(next)] > maxRight) {
                    maxRight = index.get(next) + ranges[index.get(next)];
                    i = next;
                }
                next++;
            }
            if (index.get(i) - ranges[index.get(i)] <= right) {
                right = index.get(i) + ranges[index.get(i)];
            }
            ans++;
        }
        return left <= 0 && right >= n ? ans : -1;
    }

    public int minTaps02(int n, int[] ranges) {
        int[] maxRight = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            maxRight[i] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            maxRight[left] = Math.max(maxRight[left], right);
        }

        int nowRight = 0, ans = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            nowRight = Math.max(nowRight, maxRight[i]);
            if (i == nowRight) {
                return -1;
            }
            if (i == pre) {
                ans++;
                pre = nowRight;
            }
        }
        return ans;
    }
}
