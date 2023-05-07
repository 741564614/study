package leetcode.leetcode202305;

import java.util.*;

public class leetcode_1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int mod = time[i] % 60;
            map.putIfAbsent(mod, new ArrayList<>());
            map.get(mod).add(i);
        }

        for (int i = 0; i < time.length; i++) {
            int need = (60 - time[i] % 60) % 60;
            if (map.containsKey(need)) {
                List<Integer> list = map.get(need);
                int index = binarySearch(list, i);
                ans += list.size() - (index < list.size() && list.get(index) == i ? index + 1 : index);
            }
        }
        return ans;
    }

    public int binarySearch(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int numPairsDivisibleBy60_02(int[] time) {
        long ans = 0;
        int[] cnt = new int[60];
        for (int value : time) {
            cnt[value % 60]++;
        }
        ans += (long) cnt[0] * (cnt[0] - 1) / 2;
        ans += (long) cnt[30] * (cnt[30] - 1) / 2;
        for (int i = 1; i < 30; i++) {
            ans += (long) cnt[i] * cnt[60 - i];
        }
        return (int) ans;
    }

}
