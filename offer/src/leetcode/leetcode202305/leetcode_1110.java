package leetcode.leetcode202305;

import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode_1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        boolean[] delete = new boolean[1001];
        for (int i : to_delete) {
            delete[i] = true;
        }
        TreeNode node=dfs(ans, root, delete);
        if(node!=null){
            ans.add(node);
        }
        return ans;
    }

    public TreeNode dfs(List<TreeNode> ans, TreeNode root, boolean[] delete) {
        if (root == null) {
            return null;
        }
        if (delete[root.val]) {
            TreeNode left = dfs(ans, root.left, delete);
            TreeNode right = dfs(ans, root.right, delete);
            if (left != null) {
                ans.add(left);
            }
            if (right != null) {
                ans.add(right);
            }
            return null;
        }
        root.left = dfs(ans, root.left, delete);
        root.right = dfs(ans, root.right, delete);
        return root;
    }


    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            Set<Integer> toDeleteSet = new HashSet<Integer>();
            for (int val : to_delete) {
                toDeleteSet.add(val);
            }
            List<TreeNode> roots = new ArrayList<TreeNode>();
            dfs(root, true, toDeleteSet, roots);
            return roots;
        }

        public TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> toDeleteSet, List<TreeNode> roots) {
            if (node == null) {
                return null;
            }
            boolean deleted = toDeleteSet.contains(node.val);
            node.left = dfs(node.left, deleted, toDeleteSet, roots);
            node.right = dfs(node.right, deleted, toDeleteSet, roots);
            if (deleted) {
                return null;
            } else {
                if (isRoot) {
                    roots.add(node);
                }
                return node;
            }
        }
    }

}
