package leetcode.leetcode202302;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class leetcode_2357 {
    public int minimumOperations(int[] nums) {
        return Arrays.stream(nums).filter(i -> i > 0).distinct().toArray().length;
    }

    public int minimumOperations20(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }
}
