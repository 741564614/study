package leetcode.leetcode202304;

import leetcode.TreeNode;

public class leetcode_1026 {
    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    public void dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        maxDiff = Math.max(maxDiff, max - min);
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }


    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return dfs(root, root.val, root.val);
        }

        public int dfs(TreeNode root, int mi, int ma) {
            if (root == null) {
                return 0;
            }
            int diff = Math.max(Math.abs(root.val - mi), Math.abs(root.val - ma));
            mi = Math.min(mi, root.val);
            ma = Math.max(ma, root.val);
            diff = Math.max(diff, dfs(root.left, mi, ma));
            diff = Math.max(diff, dfs(root.right, mi, ma));
            return diff;
        }
    }
}
