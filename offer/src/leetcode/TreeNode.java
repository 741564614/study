package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode gen(int[] vals) {
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < vals.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (index < vals.length) {
                    poll.left = new TreeNode(vals[index++]);
                    queue.offer(poll.left);
                }
                if (index < vals.length) {
                    poll.right = new TreeNode(vals[index++]);
                    queue.offer(poll.right);
                }
            }
        }
        return root;
    }
}
