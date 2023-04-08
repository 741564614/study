package leetcode.leetcode202304;

import java.util.*;
import java.util.Map;

public class leetcode_1125 {
    public int[] smallestSufficientTeam02(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            skillMap.put(req_skills[i], i);
        }
        int n = req_skills.length;
        List<Integer>[] dp = new List[1 << n];
        dp[0] = new ArrayList<>();
        for (int prev = 0; prev < people.size(); prev++) {
            int curSkill = 0;
            for (String s : people.get(prev)) {
                curSkill |= (1 << skillMap.get(s));
            }
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == null) {
                    continue;
                }
                int next = curSkill | i;
                if (dp[next] == null || dp[i].size() + 1 < dp[next].size()) {
                    dp[next] = new ArrayList<>(dp[i]);
                    dp[next].add(prev);
                }
            }
        }
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
    }
}
