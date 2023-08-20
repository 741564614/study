package leetcode.leetcode202308;

import leetcode.TreeNode;

public class leetcode_2236 {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
