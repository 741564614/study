package leetcode.leetcode202303;

import java.util.*;

public class leetcode_1638 {

    public static void main(String[] args) {
        String s = "abbab";
        String t = "bbbbb";
        System.out.println(new leetcode_1638().countSubstrings(s, t));
    }

    public int countSubstrings(String s, String t) {
        Map<String, Set<Integer>> matchMap = new HashMap<>();
        Map<String, Set<Integer>> misMatchMap = new HashMap<>();
        int ans = 0;
        for (int size = 1; size <= s.length(); size++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + size <= s.length()) {
                    String sub = s.substring(i, i + size);
                    matchMap.putIfAbsent(sub, new HashSet<>());
                    misMatchMap.putIfAbsent(sub, new HashSet<>());
                    if (size == 1) {
                        if (matchMap.get(sub).size() == 0 && misMatchMap.get(sub).size() == 0) {
                            for (int j = 0; j < t.length(); j++) {
                                if (t.charAt(j) == sub.charAt(0)) {
                                    matchMap.get(sub).add(j);
                                } else {
                                    misMatchMap.get(sub).add(j);
                                    ans++;
                                }
                            }
                        } else {
                            ans += misMatchMap.get(sub).size();
                        }
                    } else {
                        String prefix = sub.substring(0, sub.length() - 1);
                        for (Integer index : matchMap.get(prefix)) {
                            if (index + size - 1 < t.length()) {
                                if (t.charAt(index + size - 1) == sub.charAt(sub.length() - 1)) {
                                    matchMap.get(sub).add(index);
                                } else {
                                    misMatchMap.get(sub).add(index);
                                    ans++;
                                }
                            }
                        }

                        for (Integer index : misMatchMap.get(prefix)) {
                            if (index + size - 1 < t.length()) {
                                if (t.charAt(index + size - 1) == sub.charAt(sub.length() - 1)) {
                                    misMatchMap.get(sub).add(index);
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

    public int countSubstrings02(String s, String t) {
        int m = s.length(), n = t.length();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = 0;
                for (int k = 0; i + k < m && j + k < n; k++) {
                    diff += s.charAt(i + k) == t.charAt(j + k) ? 0 : 1;
                    if (diff > 1) {
                        break;
                    } else if (diff == 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    class Solution {
        public int countSubstrings(String s, String t) {
            int m = s.length(), n = t.length();
            int[][] dpl = new int[m + 1][n + 1];
            int[][] dpr = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dpl[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? (dpl[i][j] + 1) : 0;
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    dpr[i][j] = s.charAt(i) == t.charAt(j) ? (dpr[i + 1][j + 1] + 1) : 0;
                }
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (s.charAt(i) != t.charAt(j)) {
                        ans += (dpl[i][j] + 1) * (dpr[i + 1][j + 1] + 1);
                    }
                }
            }
            return ans;
        }
    }

}
