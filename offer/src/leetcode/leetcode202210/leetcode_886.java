package leetcode.leetcode202210;

import java.util.*;

public class leetcode_886 {
    boolean ans = true;
    boolean[] colors;
    boolean[] visited;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        colors = new boolean[n + 1];
        visited = new boolean[n + 1];
        List<Integer>[] lists = buildGraph(dislikes, n);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(lists, i);
            }
        }
        return ans;
    }

    public List<Integer>[] buildGraph(int[][] dislikes, int n) {
        List<Integer>[] result = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            result[dislike[0]].add(dislike[1]);
            result[dislike[1]].add(dislike[0]);
        }
        return result;
    }

    public void dfs(List<Integer>[] graph, int v) {
        if (!ans) {
            return;
        }
        visited[v] = true;
        for (Integer w : graph[v]) {
            if (!visited[w]) {
                colors[w] = !colors[v];
                dfs(graph, w);
            } else {
                if (colors[w] == colors[v]) {
                    ans = false;
                    return;
                }
            }
        }
    }

    public boolean possibleBipartition20(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] fa = new int[n + 1];
        Arrays.fill(fa, -1);
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            for (Integer v : graph[i]) {
                union(graph[i].get(0), v, fa);
                if (check(i, v, fa)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int x, int y, int[] fa) {
        x = find(x, fa);
        y = find(y, fa);
        if (x == y) {
            return;
        }
        if (fa[x] < fa[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        fa[x] += fa[y];
        fa[y] = x;
    }

    public boolean check(int x, int y, int[] fa) {
        return find(x, fa) == find(y, fa);
    }

    public int find(int x, int[] fa) {
        return fa[x] < 0 ? x : (fa[x] = find(fa[x], fa));
    }


}
