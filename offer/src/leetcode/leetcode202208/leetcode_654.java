package leetcode.leetcode202208;

import leetcode.TreeNode;

import java.util.Arrays;

public class leetcode_654 {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 2, 1, 6, 0, 5};
        System.out.println(constructMaximumBinaryTree(ints));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        return dfs(nums, 0, nums.length);
    }

    public static TreeNode dfs(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int maxIndex = maxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = dfs(nums, start, maxIndex);
        root.right = dfs(nums, maxIndex + 1, end);
        return root;
    }

    public static int maxIndex(int[] nums, int start, int end) {
        int index = 0, max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        return index;
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        TreeNode[] stk = new TreeNode[1010];
        int he = 0, ta = 0;
        for (int x : nums) {
            TreeNode node = new TreeNode(x);
            while (he < ta && stk[ta - 1].val < x) node.left = stk[--ta];
            if (he < ta) stk[ta - 1].right = node;
            stk[ta++] = node;
        }
        return stk[0];
    }
}
