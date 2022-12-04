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
}
