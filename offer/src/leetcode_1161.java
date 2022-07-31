import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1161 {
    public int maxLevelSum(TreeNode root) {
        int ans = 1,max=Integer.MIN_VALUE;
        int curLod=1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int sum=0;
            for (int i = 0; i < size; i++) {
                TreeNode cur=queue.poll();
                sum+=cur.val;
                if(null!=cur.left){
                    queue.offer(cur.left);
                }
                if(null!=cur.right){
                    queue.offer(cur.right);
                }
            }
            if(sum>max){
                max=sum;
                ans=curLod;
            }
            curLod++;
        }
        return ans;
    }
}
