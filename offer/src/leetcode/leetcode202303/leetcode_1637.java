package leetcode.leetcode202303;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            max = Math.max(max, points[i + 1][0] - points[i][0]);
        }
        return max;
    }

    class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            int n = points.length;
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = points[i][0];
            }
            final int inf = 1 << 30;
            int mi = inf, mx = -inf;
            for (int v : nums) {
                mi = Math.min(mi, v);
                mx = Math.max(mx, v);
            }
            int bucketSize = Math.max(1, (mx - mi) / (n - 1));
            int bucketCount = (mx - mi) / bucketSize + 1;
            int[][] buckets = new int[bucketCount][2];
            for (var bucket : buckets) {
                bucket[0] = inf;
                bucket[1] = -inf;
            }
            for (int v : nums) {
                int i = (v - mi) / bucketSize;
                buckets[i][0] = Math.min(buckets[i][0], v);
                buckets[i][1] = Math.max(buckets[i][1], v);
            }
            int prev = inf;
            int ans = 0;
            for (var bucket : buckets) {
                if (bucket[0] > bucket[1]) {
                    continue;
                }
                ans = Math.max(ans, bucket[0] - prev);
                prev = bucket[1];
            }
            return ans;
        }
    }
}
