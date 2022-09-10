package leetcode.leetcode202209;

import leetcode.TreeNode;

public class leetcode_669 {
    public static void main(String[] args) {

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (null == root) {
            return root;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
