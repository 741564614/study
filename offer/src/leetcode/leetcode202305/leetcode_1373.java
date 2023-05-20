package leetcode.leetcode202305;

import leetcode.TreeNode;

public class leetcode_1373 {
//    int max = 0;
//
//    public int maxSumBST(TreeNode root) {
//        dfs(root);
//        return max;
//    }
//
//    public void dfs(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        if (check(root) && checkLeft(root.left, root.val) && checkRight(root.right, root.val)) {
//            max = Math.max(max, sum(root));
//        }
//        dfs(root.left);
//        dfs(root.right);
//    }
//
//    public boolean check(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (root.left != null && (root.left.val >= root.val)) {
//            return false;
//        }
//        if (root.right != null && (root.right.val <= root.val)) {
//            return false;
//        }
//        return true;
//    }
//
//    public boolean checkRight(TreeNode root, int min) {
//        if (root == null) {
//            return true;
//        }
//        if (root.left != null && (root.left.val >= root.val || root.left.val <= min)) {
//            return false;
//        }
//        if (root.right != null && (root.right.val <= root.val || root.right.val <= min)) {
//            return false;
//        }
//        return checkLeft(root.left, Math.max(min, root.val)) && checkRight(root.right, Math.min(min, root.val));
//    }
//
//    public boolean checkLeft(TreeNode root, int max) {
//        if (root == null) {
//            return true;
//        }
//        if (root.left != null && (root.left.val >= root.val || root.left.val >= max)) {
//            return false;
//        }
//        if (root.right != null && (root.right.val <= root.val || root.right.val >= max)) {
//            return false;
//        }
//        return checkLeft(root.left, Math.max(max, root.val)) && checkRight(root.right, Math.min(max, root.val));
//    }
//
//    public int sum(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return root.val + sum(root.left) + sum(root.right);
//    }


    class SubTree {
        Boolean isBST;
        int max;
        int min;
        int sum;

        public SubTree(Boolean isBST, int max, int min, int sum) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }

    int ans;

    public int maxSumBST(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public SubTree dfs(TreeNode root) {
        if (root == null) {
            return new SubTree(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        SubTree left = dfs(root.left);
        SubTree right = dfs(root.right);
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int sum = left.sum + right.sum + root.val;
            ans = Math.max(ans, sum);
            return new SubTree(true, Math.max(right.max, root.val), Math.min(left.min, root.val), sum);
        }
        return new SubTree(false, 0, 0, 0);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(10);
        treeNode.right.left = new TreeNode(-5);
        treeNode.right.right = new TreeNode(20);
        System.out.println(new leetcode_1373().maxSumBST(treeNode));
    }
}
