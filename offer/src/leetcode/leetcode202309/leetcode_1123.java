package leetcode.leetcode202309;

import javafx.util.Pair;
import leetcode.TreeNode;

import java.util.*;

public class leetcode_1123 {

    public static void main(String[] args) {
        System.out.println(new leetcode_1123().lcaDeepestLeaves(new TreeNode(1)));
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> prevMap = new HashMap<>();
        prevMap.put(root, null);
        Map<Integer, Set<TreeNode>> deepMap = new HashMap<>();
        int deep = 0;
        deepMap.put(deep, new HashSet<>());
        deepMap.get(deep).add(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            deepMap.put(++deep, new HashSet<>());
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    prevMap.put(poll.left, poll);
                    queue.offer(poll.left);
                    deepMap.get(deep).add(poll.left);
                }
                if (poll.right != null) {
                    prevMap.put(poll.right, poll);
                    queue.offer(poll.right);
                    deepMap.get(deep).add(poll.right);
                }
            }
        }
        queue.addAll(deepMap.get(deep - 1));
        Set<TreeNode> set = deepMap.get(deep - 1);
        while (set.size() > 1) {
            int size = queue.size();
            set.clear();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode prev = prevMap.get(poll);
                if (!set.contains(prev)) {
                    set.add(prev);
                    queue.offer(prev);
                }
            }
        }
        return (TreeNode) set.toArray()[0];
    }

    class Solution {
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            return dfs(root).getKey();
        }

        public Pair<TreeNode, Integer> dfs(TreeNode root) {
            if (root == null) {
                return new Pair<>(null, 0);
            }
            Pair<TreeNode, Integer> left = dfs(root.left);
            Pair<TreeNode, Integer> right = dfs(root.right);
            return left.getValue().equals(right.getValue()) ? new Pair<>(root, left.getValue() + 1) : left.getValue() > right.getValue() ? new Pair<>(left.getKey(), left.getValue() + 1) : new Pair<>(right.getKey(), right.getValue() + 1);
        }
    }


}
