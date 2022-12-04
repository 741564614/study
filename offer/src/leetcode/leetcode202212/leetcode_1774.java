package leetcode.leetcode202212;

public class leetcode_1774 {
    int ans = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int baseCost : baseCosts) {
            dfs(toppingCosts, 0, target, baseCost);
        }
        return ans;
    }

    public void dfs(int[] toppingCosts, int index, int target, int cost) {
        if (Math.abs(target - ans) > Math.abs(target - cost) || (Math.abs(target - ans) == Math.abs(target - cost) && ans > cost)) {
            ans = cost;
        }
        if (cost >= target) {
            return;
        }
        for (int i = index; i < toppingCosts.length; i++) {
            dfs(toppingCosts, i + 1, target, cost);
            dfs(toppingCosts, i + 1, target, cost + toppingCosts[i]);
            dfs(toppingCosts, i + 1, target, cost + 2 * toppingCosts[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new leetcode_1774().closestCost02(new int[]{2, 3}, new int[]{4, 5, 100}, 18));
    }

    public int closestCost02(int[] base, int[] top, int V) {
        boolean[] dp = new boolean[V + 5];
        int ans = Integer.MAX_VALUE;
        for (int x : base) { //判断只能选基料
            if (x > V) ans = Math.min(ans, x);
            else dp[x] = true;
        }
        for (int x : top) {
            for (int i = 0; i < 2; i++) { //选2次
                for (int j = V; j >= 0; j--) {
                    if (dp[j] && j + x > V) ans = Math.min(ans, j + x); //计算大于的情况
                    if (j > x) dp[j] |= dp[j - x];
                }
            }
        }
        //ans-V:目前获得与target的差距
        for (int i = 0; i <= ans - V && i <= V; i++) if (dp[V - i]) return V - i;
        return ans;
    }
}
