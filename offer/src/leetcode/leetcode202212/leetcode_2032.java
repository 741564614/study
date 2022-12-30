package leetcode.leetcode202212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[][] check = new int[110][3];
        for (int i : nums1) {
            if (check[i][0] == 0) {
                check[i][0]++;
            }
        }

        for (int i : nums2) {
            if (check[i][1] == 0) {
                check[i][1]++;
            }
        }

        for (int i : nums3) {
            if (check[i][2] == 0) {
                check[i][2]++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < check.length; i++) {
            if (check[i][0] + check[i][1] + check[i][2] >= 2) {
                result.add(i);
            }
        }

        return result;
    }
    public List<Integer> twoOutOfThree20(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) | 2);
        }
        for (int i : nums3) {
            map.put(i, map.getOrDefault(i, 0) | 4);
        }
        List<Integer> res = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            if ((v & (v - 1)) != 0) {
                res.add(k);
            }
        }
        return res;
    }
}
