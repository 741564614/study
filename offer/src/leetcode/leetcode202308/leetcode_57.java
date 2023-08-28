package leetcode.leetcode202308;

import java.util.*;

public class leetcode_57 {


    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 5}};
        System.out.println(Arrays.deepToString(new leetcode_57().insert(intervals, new int[]{2, 3})));
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0], end = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int curStart = intervals[i][0], curEnd = intervals[i][1];
            //(curStart >= start &&(curStart <= end||curEnd >= end))||(curEnd <= end&&(curEnd >= start||))
            if ((curStart <= end && curStart >= start) || (curEnd >= start && curEnd <= end) || (curStart <= start && curEnd >= end) || (start <= curStart && end >= curEnd)) {
                start = Math.min(start, curStart);
                end = Math.max(end, curEnd);
            } else {
                if (curStart <= start) {
                    ans.add(new int[]{curStart, curEnd});
                } else {
                    ans.add(new int[]{start, end});
                    start = curStart;
                    end = curEnd;
                }
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[0][]);
    }
}
