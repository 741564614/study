package leetcode.leetcode202303;

import java.util.*;

public class leetcode_1617 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {2, 4}};
        System.out.println(Arrays.toString(new leetcode_1617().countSubgraphsForEachDiameter02(4, edges)));
        int i = 4;
        int x = 32 - Integer.numberOfLeadingZeros(i) - 1;
        System.out.println(x);
        int mask = i & ~(1 << x);
        System.out.println(mask);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(~(1 << x)));
        System.out.println(1 << 4);
    }

    public int[] countSubgraphsForEachDiameter02(int n, int[][] edges) {
        int[] ans = new int[n - 1];
        //邻接表
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            //下标转换成从0开始
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            adj[x].add(y);
            adj[y].add(x);
        }

        //二进制枚举，每有一个城市就多一位，枚举每一位上或0或1，即0到1<<n
        for (int i = 1; i < (1 << n); i++) {
            int index = 32 - Integer.numberOfLeadingZeros(i) - 1;
            int mask = i;
            //这个子集最远端点
            int last = -1;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(index);
            //index已被选择过
            mask &= ~(1 << index);
            //广度优先搜索，判断该子集是否连通并寻找最远端点
            while (!queue.isEmpty()) {
                last = queue.poll();
                for (Integer temp : adj[last]) {
                    //在该子集中并未被选择
                    if ((mask & (1 << temp)) != 0) {
                        //选择
                        mask &= ~(1 << temp);
                        //进入搜索列表
                        queue.offer(temp);
                    }
                }
            }

            //如果该子集是连通并且都选择过了
            if (mask == 0) {
                int depth = dfs(adj, -1, last, i);
                if (depth > 0) {
                    ans[depth - 1]++;
                }
            }
        }
        return ans;
    }

    /**
     * 从最远端点递归找树的直径
     *
     * @param adj
     * @param parent
     * @param cur
     * @param mask
     * @return
     */
    public int dfs(List<Integer>[] adj, int parent, int cur, int mask) {
        int depth = 0;
        for (int temp : adj[cur]) {
            //避免走回头路并且判断是否在子集里
            if (temp != parent && (mask & (1 << temp)) != 0) {
                depth = Math.max(depth, dfs(adj, cur, temp, mask) + 1);
            }
        }
        return depth;
    }

}
