package leetcode.leetcode202309;

import java.util.*;

public class leetcode_210 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new leetcode_210().findOrder(2, new int[][]{{1, 0}})));
    }

    List<List<Integer>> edge = new ArrayList<>();
    List<Integer> stack = new ArrayList<>();
    int[] visited;
    boolean over = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int prev = prerequisite[1], next = prerequisite[0];
            edge.get(prev).add(next);
        }
        for (int i = 0; i < numCourses && !over; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        Collections.reverse(stack);
        return over ? new int[0] : stack.stream().mapToInt(a -> a).toArray();
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (Integer v : edge.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (over) {
                    return;
                }
            } else if (visited[v] == 1) {
                over = true;
                return;
            }
        }
        visited[u] = 2;
        stack.add(u);
    }

    class Solution {
        // 存储有向图
        List<List<Integer>> edges;
        // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
        int[] visited;
        // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
        int[] result;
        // 判断有向图中是否有环
        boolean valid = true;
        // 栈下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            visited = new int[numCourses];
            result = new int[numCourses];
            index = numCourses - 1;
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
            for (int i = 0; i < numCourses && valid; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            if (!valid) {
                return new int[0];
            }
            // 如果没有环，那么就有拓扑排序
            return result;
        }

        public void dfs(int u) {
            // 将节点标记为「搜索中」
            visited[u] = 1;
            // 搜索其相邻节点
            // 只要发现有环，立刻停止搜索
            for (int v: edges.get(u)) {
                // 如果「未搜索」那么搜索相邻节点
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                }
                // 如果「搜索中」说明找到了环
                else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            // 将节点标记为「已完成」
            visited[u] = 2;
            // 将节点入栈
            result[index--] = u;
        }
    }

}
