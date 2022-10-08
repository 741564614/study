package leetcode.leetcode202210;

import java.util.*;

public class leetcode_870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            set.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            Integer ceiling = set.ceiling(key + 1);
            if (null == ceiling) {
                ceiling = set.ceiling(-1);
            }
            ans[i] = ceiling;
            map.put(ceiling, map.get(ceiling) - 1);
            if (map.get(ceiling) == 0) {
                set.remove(ceiling);
            }
        }
        return ans;
    }

    public int[] advantageCount02(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx = new Integer[n]; // nums2索引
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(nums1);
        Arrays.sort(idx, Comparator.comparingInt(i -> nums2[i])); //根据nums2数据升序，排序nums2(索引)
        int L = 0, R = n - 1; // nums2(索引)的左右指针
        for (int i : nums1) { // 遍历nums1
            if (i > nums2[idx[L]]) nums2[idx[L++]] = i; // 可以满足 nums1[i] > nums2[i]
            else nums2[idx[R--]] = i; //丢到数组最后
        }
        return nums2;
    }
}
