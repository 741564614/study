package leetcode.leetcode202209;

import leetcode.TreeNode;

import java.util.*;

public class leetcode_652 {
    public static void main(String[] args) {

    }

    Map<String, Integer> map = new HashMap<>(16);
    Map<String, TreeNode> nodeMap = new HashMap<>(16);

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        List<TreeNode> result = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v > 1) {
                result.add(nodeMap.get(k));
            }
        });
        return result;
    }

    public String dfs(TreeNode root) {
        if (null == root) {
            return "_null";
        }
        String key = "_" + root.val + dfs(root.left) + dfs(root.right);
        map.put(key, map.getOrDefault(key, 0) + 1);
        nodeMap.put(key, root);
        return key;
    }
}
