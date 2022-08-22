package leetcode.leetcode202208;

import leetcode.TreeNode;

import java.util.*;

public class leetcode_655 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(printTree(root));
    }

    public static List<List<String>> printTree(TreeNode root) {
        List<LinkedList<String>> ans = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> nodeY = new LinkedList<>();
        nodes.offer(root);
        int deep = getDeep(root, 0);
        int resSize = (int) (Math.pow(2, deep + 1) - 1);
        nodeY.offer((resSize - 1) / 2);
        int r = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodes.poll();

                int y = nodeY.poll();
                if (ans.size() < deep + 1) {
                    LinkedList<String> res = new LinkedList<>();
                    while (res.size() < resSize) {
                        res.add("");
                    }
                    ans.add(res);
                }
                ans.get(r).set(y, String.valueOf(cur.val));
                if (cur.left != null) {
                    nodes.offer(cur.left);
                    //c-2height-r-1
                    nodeY.offer((int) (y-Math.pow(2,deep-r-1)));
                }
                if (cur.right != null) {
                    nodes.offer(cur.right);
                    nodeY.offer((int) (y+Math.pow(2,deep-r-1)));
                }
            }
            r++;
        }
        return new ArrayList<>(ans);
    }

    public static int getDeep(TreeNode root, int deep) {
        if (root == null) {
            return deep-1;
        }
        return Math.max(getDeep(root.left, deep + 1), getDeep(root.right, deep + 1));
    }
}
