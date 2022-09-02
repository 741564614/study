package leetcode.leetcode202209;

import leetcode.TreeNode;

public class leetcode_687 {
    public static void main(String[] args) {
        TreeNode k = new TreeNode(5);
        k.left = new TreeNode(4);
        k.right = new TreeNode(5);
        k.left.left = new TreeNode(1);
        k.left.right = new TreeNode(1);
        k.right.right = new TreeNode(5);
        System.out.println(longestUnivaluePath(k));
    }

    static int max = 0;

    public static int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    static int dfs(TreeNode root) {
        if (root == null) return 0;
        int ans = 0, cur = 0, l = dfs(root.left), r = dfs(root.right);
        if (root.left != null && root.left.val == root.val) {
            ans = l + 1;
            cur += l + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            ans = Math.max(ans, r + 1);
            cur += r + 1;
        }
        max = Math.max(max, cur);
        return ans;
    }
//
//
//    public static int longestUnivaluePath(TreeNode root) {
//        dfs2(root);
//        return max;
//    }
//
//    public static void dfs2(TreeNode root) {
//        if (null == root) {
//            return;
//        }
//        max = Math.max(max, dfs(root.left, root.val, 0) + dfs(root.right, root.val, 0));
//        dfs2(root.left);
//        dfs2(root.right);
//    }
//
//    public static int dfs(TreeNode cur, int lastVal, int deep) {
//        if (null == cur) {
//            return deep;
//        }
//        if (cur.val != lastVal) {
//            return 0;
//        }
//        return Math.max(dfs(cur.left, lastVal, deep + 1), dfs(cur.right, lastVal, deep + 1));
//    }
}
