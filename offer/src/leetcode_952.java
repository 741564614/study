import java.util.*;

public class leetcode_952 {
    public static void main(String[] args) {
        int[] nums=new int[]{4,6,15,35};
        System.out.println(largestComponentSize(nums));
    }
    static int N = 20010;
    static int[] p = new int[N], sz = new int[N];
    static int ans = 1;
    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    static void union(int a, int b) {
        if (find(a) == find(b)) return ;
        sz[find(a)] += sz[find(b)];
        p[find(b)] = p[find(a)];
        ans = Math.max(ans, sz[find(a)]);
    }
    public static int largestComponentSize(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            //找公因数，每次找到一个公因数就开始除掉，等于缩小循环范围，因为j<=根号cur
            for (int j = 2; j * j <= cur; j++) {
                //找到公因数就加到图里
                if (cur % j == 0) add(map, j, i);
                //把这个公因数全除掉，找下一个公因数
                while (cur % j == 0) cur /= j;
            }
            //如果剩下的数大于1，说明是最后一个公因数，也加进图里
            if (cur > 1) add(map, cur, i);
        }
        //初始化并查集
        for (int i = 0; i <= n; i++) {
            p[i] = i; sz[i] = 1;
        }
        //开始合并
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int i = 1; i < list.size(); i++) union(list.get(0), list.get(i));
        }
        return ans;
    }
    static void add(Map<Integer, List<Integer>> map, int key, int val) {
        List<Integer> list = map.getOrDefault(key, new ArrayList<>());
        list.add(val);
        map.put(key, list);
    }
}
