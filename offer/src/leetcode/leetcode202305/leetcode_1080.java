package leetcode.leetcode202305;

import leetcode.TreeNode;

public class leetcode_1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit);
    }

    public TreeNode dfs(TreeNode root, int nowValue, int limit) {
        if (root.left == null && root.right == null) {
            return nowValue + root.val < limit ? null : root;
        }
        if (root.left != null) {
            root.left = dfs(root.left, nowValue + root.val, limit);
        }
        if (root.right != null) {
            root.right = dfs(root.right, nowValue + root.val, limit);
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
