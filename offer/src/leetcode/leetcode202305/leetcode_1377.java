package leetcode.leetcode202305;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.*;

public class leetcode_1377 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(n==1){
            return 1;
        }
        ArrayList<Integer>[] matrix = new ArrayList[n + 1];
        for (int[] edge : edges) {
            if (matrix[edge[0]] == null) {
                matrix[edge[0]] = new ArrayList<>();
            }
            matrix[edge[0]].add(edge[1]);

            if (matrix[edge[1]] == null) {
                matrix[edge[1]] = new ArrayList<>();
            }
            matrix[edge[1]].add(edge[0]);
        }

        LinkedList<Node> queue = new LinkedList<>();
        Node root = new Node(new LinkedHashSet<>(), 1, 1);
        root.path.add(1);
        queue.offer(root);
        while (t > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                int toSize = notIn(poll.path, matrix[poll.index]);
                if (poll.path.size() == n || toSize == 0) {
                    queue.offer(poll);
                    continue;
                }
                for (Integer next : matrix[poll.index]) {
                    if (!poll.path.contains(next)) {
                        Node node = new Node(new LinkedHashSet<>(poll.path), next, poll.chance / toSize);
                        node.path.add(next);
                        queue.offer(node);
                    }
                }
            }
            t--;
        }
        double ans = 0;
        for (Node node : queue) {
            if (node.index == target) {
                ans += node.chance;
            }
        }
        return ans;
    }

    public int notIn(Set<Integer> path, List<Integer> next) {
        int ans = 0;
        for (Integer value : next) {
            if (!path.contains(value)) {
                ans++;
            }
        }
        return ans;
    }

    class Node {
        LinkedHashSet<Integer> path;
        int index;
        double chance;

        public Node(LinkedHashSet<Integer> path, int index, double chance) {
            this.path = path;
            this.index = index;
            this.chance = chance;
        }
    }

    public class Solution {
        public double frogPosition(int n, int[][] edges, int t, int target) {
            List<Integer>[] G = new ArrayList[n + 1];
            for (int i = 1; i <= n; ++i)
                G[i] = new ArrayList<>();
            for (int[] e : edges) {
                G[e[0]].add(e[1]);
                G[e[1]].add(e[0]);
            }
            boolean[] seen = new boolean[n + 1];
            return dfs(G, seen, 1, t, target);
        }

        private double dfs(List<Integer>[] G, boolean[] seen, int i, int t, int target) {
            int nxt = i == 1 ? G[i].size() : G[i].size() - 1;
            if (t == 0 || nxt == 0) {
                return i == target ? 1.0 : 0.0;
            }
            seen[i] = true;
            double ans = 0.0;
            for (int j : G[i]) {
                if (!seen[j]) {
                    ans += dfs(G, seen, j, t - 1, target);
                }
            }
            return ans / nxt;
        }
    }

}
