package leetcode.leetcode202209;

import java.util.*;

public class leetcode_1624 {
    public static void main(String[] args) {

    }

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, LinkedList<Integer>> hashMap = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            LinkedList<Integer> orDefault = hashMap.getOrDefault(a, new LinkedList<>());
            orDefault.add(i);
            if (orDefault.size() >= 2) {
                int temp = orDefault.getLast() - orDefault.getFirst() - 1;
                ans = Math.max(ans, temp);
            }
            hashMap.put(a, orDefault);
        }
        return ans;
    }

    public int maxLengthBetweenEqualCharacters02(String s) {
        int[] idxs = new int[26];
        Arrays.fill(idxs, 310);
        int n = s.length(), ans = -1;
        for (int i = 0; i < n; i++) {
            int u = s.charAt(i) - 'a';
            idxs[u] = Math.min(idxs[u], i);
            ans = Math.max(ans, i - idxs[u] - 1);
        }
        return ans;
    }
}
