package leetcode.leetcode202307;

import leetcode.TreeNode;

import java.util.*;

public class leetcode_979 {
    class solution {
        int ans = 0;

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return ans;
        }

        public int dfs(TreeNode root) {
            int ml = 0, mr = 0;
            if (root == null) {
                return 0;
            }
            if (root.left != null) {
                ml = dfs(root.left);
            }
            if (root.right != null) {
                mr = dfs(root.right);
            }
            ans += Math.abs(ml) + Math.abs(mr);
            return ml + mr + root.val - 1;
        }
    }

}
