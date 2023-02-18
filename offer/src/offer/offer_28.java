package offer;

import leetcode.TreeNode;

import java.util.*;

public class offer_28 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll == null ? null : poll.val);
                if (poll != null) {
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }

            int l = 0, r = list.size() - 1;
            while (l <= r) {
                if (!Objects.equals(list.get(l++), list.get(r--))) {
                    return false;
                }
            }
            if (queue.size() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(2);
        System.out.println(new offer_28().isSymmetric02(root));
    }

    public boolean isSymmetric02(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
    }

}
