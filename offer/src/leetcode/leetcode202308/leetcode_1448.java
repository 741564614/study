package leetcode.leetcode202308;

import leetcode.TreeNode;

public class leetcode_1448 {
    public int goodNodes(TreeNode root) {
        return getGood(root, root.val);
    }

    public int getGood(TreeNode root, int maxValue) {
        if (root == null) {
            return 0;
        }
        int max = Math.max(maxValue, root.val);
        return getGood(root.left, max) + getGood(root.right, max) + (max > root.val ? 0 : 1);
    }
}
