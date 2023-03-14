package offer;

import leetcode.TreeNode;

public class offer_54 {
    int target;
    int ans;

    public int kthLargest(TreeNode root, int k) {
        ans = 0;
        target = k;
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        target--;
        if (target == 0) {
            ans = root.val;
            return;
        }
        dfs(root.left);
    }

    class Solution {
        int res, k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }
        void dfs(TreeNode root) {
            if(root == null) return;
            dfs(root.right);
            if(k == 0) return;
            if(--k == 0) res = root.val;
            dfs(root.left);
        }
    }
}
