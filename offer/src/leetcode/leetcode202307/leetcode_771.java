package leetcode.leetcode202307;

import java.util.*;

public class leetcode_771 {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : stones.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (char c : jewels.toCharArray()) {
            ans += map.getOrDefault(c, 0);
        }
        return ans;
    }
}
