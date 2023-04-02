package leetcode.leetcode202304;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1039 {
    class Solution {
        int n;
        int[] values;
        Map<Integer, Integer> map = new HashMap<>();

        public int minScoreTriangulation(int[] values) {
            n = values.length;
            this.values = values;
            return dp(0, n - 1);
        }

        public int dp(int i, int j) {
            if (i + 2 > j) {
                return 0;
            }
            if (i + 2 == j) {
                return values[i] * values[i + 1] * values[j];
            }
            int key = i * n + j;
            if (!map.containsKey(key)) {
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(min, values[i] * values[k] * values[j] + dp(i, k) + dp(k, j));
                }
                map.put(key, min);
            }
            return map.get(key);
        }
    }

    class Solution02 {

        private int[] items;
        private int length;

        public int minScoreTriangulation(int[] arr) {
            this.length = arr.length;
            this.items = new int[length * length];
            return find(arr, 0, arr.length - 1);
        }

        private int find(int[] arr, int st, int end) {
            int size = end - st + 1;
            if (size < 3) {
                return 0;
            }
            int key = st * length + end;
            if (items[key] != 0) {
                return items[key];
            }
            if (size == 3) {
                items[key] = arr[st] * arr[st + 1] * arr[st + 2];
                return items[key];
            }
            int min = Integer.MAX_VALUE;
            for (int i = st + 1; i < end; i++) {
                int v = arr[st] * arr[end] * arr[i];
                if (v >= min) {
                    continue;
                }
                v += find(arr, st, i);
                if (v >= min) {
                    continue;
                }
                min = Math.min(min, v + find(arr, i, end));
            }
            items[key] = min;
            return min;
        }

    }
}
