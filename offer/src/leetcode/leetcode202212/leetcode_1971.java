package leetcode.leetcode202212;

public class leetcode_1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }

        for (int[] edge : edges) {
            union(uf, edge[0], edge[1]);
            if(find(uf, source) == find(uf, destination)){
                return true;
            }
        }

        return find(uf, source) == find(uf, destination);
    }

    public int find(int[] uf, int x) {
        if (uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf, uf[x]);
    }

    public void union(int[] uf, int x, int y) {
        x = find(uf, x);
        y = find(uf, y);
        uf[y] = x;
    }
}
