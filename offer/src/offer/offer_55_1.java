package offer;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class offer_55_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            depth++;
        }
        return depth;
    }

    int max = 0;

    public int maxDepth20(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return max;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            max = Math.max(max, depth);
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
