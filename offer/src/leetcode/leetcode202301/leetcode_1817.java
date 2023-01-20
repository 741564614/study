package leetcode.leetcode202301;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class leetcode_1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = Arrays.stream(logs).collect(Collectors.groupingBy(i -> i[0], Collectors.mapping(i -> i[1], Collectors.toSet())));
        int[] ans = new int[k];
        map.forEach((key, value) -> ans[value.size()-1]++);
        return ans;
    }
}
