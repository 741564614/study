import java.util.LinkedList;
import java.util.Queue;

public class leetcode_623 {
    public static void main(String[] args) {

    }
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int nowdepth=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(nowdepth==depth-1){
                    TreeNode newLeft=new TreeNode(val);
                    TreeNode newRight=new TreeNode(val);
                    newLeft.left=cur.left;
                    newRight.right=cur.right;
                    cur.left=newLeft;
                    cur.right=newRight;
                }
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            if(nowdepth==depth-1){
                return root;
            }
            nowdepth++;
        }
        return root;
    }
}
