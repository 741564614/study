package offer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class offer_34 {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        root.left=new TreeNode(1);
        root.right=new TreeNode(1);
        System.out.println(new offer_34().pathSum(root,1));
    }

    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        dfs(new LinkedList<>(), root, 0, target);
        return ans;
    }

    public void dfs(LinkedList<Integer> path, TreeNode root, int value, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        value += root.val;
        if (root.left == null && root.right == null) {
            if (value == target) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            dfs(path, root.left, value, target);
            dfs(path, root.right, value, target);
        }
        path.removeLast();
    }
}
