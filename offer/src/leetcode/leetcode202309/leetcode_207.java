package leetcode.leetcode202309;

import java.util.*;

public class leetcode_207 {

    public static void main(String[] args) {
        System.out.println(new leetcode_207().canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0], prev = prerequisite[1];
            map.putIfAbsent(prev, new HashSet<>());
            map.putIfAbsent(x, new HashSet<>());
            map.get(prev).add(x);
            map.get(prev).addAll(map.get(x));
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Integer[] values = entry.getValue().toArray(new Integer[0]);
            Integer key = entry.getKey();
            for (Integer value : values) {
                if (map.get(value).contains(key)) {
                    return false;
                }
            }
        }
        return true;
    }


    class Solution {
        List<List<Integer>> edges;
        int[] visited;
        boolean valid = true;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            visited = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            for (int i = 0; i < numCourses && valid; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            return valid;
        }

        public void dfs(int u) {
            visited[u] = 1;
            for (int v: edges.get(u)) {
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                } else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            visited[u] = 2;
        }
    }


}
