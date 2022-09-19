package leetcode.leetcode202209;

import java.util.*;

public class leetcode_1636 {
    public static void main(String[] args) {

    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }
        list.sort((a, b) -> map.get(a).equals(map.get(b)) ? b - a : map.get(a) - map.get(b));
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
