package leetcode.leetcode202302;

import leetcode.TreeNode;

import java.util.*;

public class leetcode_1145 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (n == 1) {
            return false;
        }
        Map<Integer, Integer> children = new HashMap<>();
        Map<Integer, Integer> indexValue = new HashMap<>();
        dfs(root, children, indexValue, 1);

        int xIndex = indexValue.get(x);

        if (xIndex == 1) {
            return !(Math.abs(children.get(2) - children.get(3)) <= 1);
        }


        return Math.max(Math.max(children.getOrDefault(xIndex * 2,0), children.getOrDefault(xIndex * 2 + 1,0)), n - children.get(xIndex)) > (n / 2);
    }

    public int dfs(TreeNode root, Map<Integer, Integer> children, Map<Integer, Integer> indexValue, int index) {
        if (root == null) {
            return 0;
        }
        indexValue.put(root.val, index);
        children.put(index, dfs(root.left, children, indexValue, index * 2) + dfs(root.right, children, indexValue, index * 2 + 1) + 1);
        return children.get(index);
    }


    TreeNode xNode;

    public boolean btreeGameWinningMove02(TreeNode root, int n, int x) {
        find(root, x);
        int leftSize = getSubtreeSize(xNode.left);
        if (leftSize >= (n + 1) / 2) {
            return true;
        }
        int rightSize = getSubtreeSize(xNode.right);
        if (rightSize >= (n + 1) / 2) {
            return true;
        }
        int remain = n - 1 - leftSize - rightSize;
        return remain >= (n + 1) / 2;
    }

    public void find(TreeNode node, int x) {
        if (xNode != null || node == null) {
            return;
        }
        if (node.val == x) {
            xNode = node;
            return;
        }
        find(node.left, x);
        find(node.right, x);
    }

    public int getSubtreeSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSubtreeSize(node.left) + getSubtreeSize(node.right);
    }
}
