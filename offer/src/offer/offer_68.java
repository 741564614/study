package offer;

import leetcode.TreeNode;

public class offer_68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if ((p.val < root.val && q.val > root.val) || (q.val < root.val && p.val > root.val)) return root;
        if (p.val == root.val) return p;
        if (q.val == root.val) return q;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor02(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor02(root.right, p, q);
        return null;
    }
}
