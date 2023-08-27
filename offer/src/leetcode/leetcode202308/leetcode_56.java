package leetcode.leetcode202308;

import java.util.*;
import java.util.Comparator;
import java.util.List;

public class leetcode_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0], nextEnd = intervals[i][1];
            if (nextStart >= start && nextStart <= end) {
                end = Math.max(end, nextEnd);
            } else {
                ans.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[0][0]);
    }
}
