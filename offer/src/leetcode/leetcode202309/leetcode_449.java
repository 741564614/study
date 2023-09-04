package leetcode.leetcode202309;

import leetcode.TreeNode;

import java.util.*;

public class leetcode_449 {

    public static void main(String[] args) {
        TreeNode root = new leetcode_449.Codec().deserialize("[5,3,6,2,4,null,null,1]");
        System.out.println(new leetcode_449.Codec().serialize(root));
    }

    static class Codec {

        public String serialize(TreeNode root) {
            if(root==null){
                return "[]";
            }
            LinkedList<String> ans = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    ans.add(poll != null ? poll.val + "" : "null");
                    if (poll != null) {
                        queue.offer(poll.left);
                        queue.offer(poll.right);
                    }
                }
            }
            while(ans.getLast().equals("null")){
                ans.removeLast();
            }
            return Arrays.toString(ans.toArray());
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length()==2){
                return null;
            }
            int[] values = Arrays.stream(data.substring(1, data.length() - 1).split(",")).mapToInt(a -> a.trim().equals("null") ? -1 : Integer.parseInt(a.trim())).toArray();
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(values[0]);
            int index = 1;
            queue.offer(root);
            while (index < values.length) {
                int size = queue.size();
                for (int i = 0; i < size&&index < values.length; i++) {
                    TreeNode poll = queue.poll();
                    if (values[index] != -1) {
                        poll.left = new TreeNode(values[index]);
                        queue.offer(poll.left);
                    }
                    if (index+1<values.length&&values[index + 1] != -1) {
                        poll.right = new TreeNode(values[index + 1]);
                        queue.offer(poll.right);
                    }
                    index += 2;
                }

            }
            return root;
        }
    }

    public class Codec02 {
        public String serialize(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            postOrder(root, list);
            String str = list.toString();
            return str.substring(1, str.length() - 1);
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] arr = data.split(", ");
            Deque<Integer> stack = new ArrayDeque<Integer>();
            int length = arr.length;
            for (int i = 0; i < length; i++) {
                stack.push(Integer.parseInt(arr[i]));
            }
            return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
        }

        private void postOrder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }

        private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
            if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
                return null;
            }
            int val = stack.pop();
            TreeNode root = new TreeNode(val);
            root.right = construct(val, upper, stack);
            root.left = construct(lower, val, stack);
            return root;
        }
    }

}
