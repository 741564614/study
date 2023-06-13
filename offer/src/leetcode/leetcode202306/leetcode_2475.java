package leetcode.leetcode202306;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class leetcode_2475 {
    public int unequalTriplets(int[] nums) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        Integer[] array = map.keySet().toArray(new Integer[]{});
        for (int i = 0; i < map.size(); i++) {
            for (int j = i + 1; j < map.size(); j++) {
                for (int k = j + 1; k < map.size(); k++) {
                    ans += map.get(array[i]) * map.get(array[j]) * map.get(array[k]);
                }
            }
        }
        return ans;
    }

    class Solution {
        public int unequalTriplets(int[] nums) {
            int res = 0, pairs = 0, i = 1, n = nums.length;
            var cnt = new int[1001];
            cnt[nums[0]] = 1;
            do {
                int count = cnt[nums[i]]++, others = i - count;
                res += pairs - count * others;
                pairs += others;
            } while (++i < n);
            return res;
        }
    }

    class Solution02 {
        public int unequalTriplets(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int x : nums) {
                count.merge(x, 1, Integer::sum);
            }
            int res = 0, n = nums.length, t = 0;
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                res += t * entry.getValue() * (n - t - entry.getValue());
                t += entry.getValue();
            }
            return res;
        }
    }
}
