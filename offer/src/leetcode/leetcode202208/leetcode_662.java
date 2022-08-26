package leetcode.leetcode202208;

import leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_662 {
    public static void main(String[] args) {

    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<Integer> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.offer(1);
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                Integer index = indexQueue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    indexQueue.offer(index * 2);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
            if (!indexQueue.isEmpty()) {
                max = Math.max(max, indexQueue.getLast() - indexQueue.getFirst() + 1);
            }
        }
        return max;
    }
}
