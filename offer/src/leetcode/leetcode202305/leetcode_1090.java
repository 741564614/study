package leetcode.leetcode202305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = values.length;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        list.sort((a, b) -> values[b] - values[a]);
        int ans = 0;
        for (int i = 0; i < n && numWanted > 0; i++) {
            int index = list.get(i);
            if (map.getOrDefault(labels[index], 0) < useLimit) {
                ans += values[index];
                map.put(labels[index], map.getOrDefault(labels[index], 0) + 1);
                numWanted--;
            }
        }
        return ans;
    }
}
