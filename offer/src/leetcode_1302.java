import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1302 {
    int res = 0;
    int maxLevel = 0;
    public int deepestLeavesSum2(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode root, int level){
        if (root == null)
            return;
        if (level > maxLevel) {
            maxLevel = level;
            res = 0;
        }
        if (level == maxLevel) {
            res += root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
    public static void main(String[] args) {

    }
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<Integer> list=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int sum=0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode=queue.poll();
                sum+=curNode.val;
                if(null!=curNode.left){
                    queue.offer(curNode.left);
                }
                if(null!=curNode.right){
                    queue.offer(curNode.right);
                }
            }
            list.add(sum);
        }
        return list.getLast();
    }
}
