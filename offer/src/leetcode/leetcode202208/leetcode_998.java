package leetcode.leetcode202208;

import leetcode.TreeNode;

public class leetcode_998 {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        TreeNode cur = root;
        if (cur.val < val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        TreeNode pre = cur;
        while (cur != null) {
            if (cur.val > val) {
                pre = cur;
                cur = cur.right;
            } else {
                TreeNode newNode = new TreeNode(val);
                newNode.left = cur;
                pre.right = newNode;
                return root;
            }
        }

        pre.right = new TreeNode(val);
        return root;
    }
}
