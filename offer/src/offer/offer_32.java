package offer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class offer_32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return list.stream().mapToInt(a -> a).toArray();
    }

    public int[] levelOrder02(TreeNode root) {
        if(root==null) return new int[0];
        List<TreeNode> list=new ArrayList<>();
        list.add(root);
        int i=0;
        while(i<list.size()){
            TreeNode r=list.get(i++);
            if(r!=null){
                if(r.left!=null)
                    list.add(r.left);
                if(r.right!=null)
                    list.add(r.right);
            }
        }
        return list.stream().map(n->n.val).mapToInt(Integer::intValue).toArray();
    }
}
