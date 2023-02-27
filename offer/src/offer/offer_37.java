package offer;

import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class offer_37 {


    public static void main(String[] args) {
        String k="[1,2,3,null,null,4,5]";
        new Codec().deserialize(k);
    }

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(null==root){
                return "[]";
            }
            StringBuilder sb = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    sb.append(poll == null ? "null" : poll.val);
                    sb.append(",");
                    if (poll != null) {
                        queue.offer(poll.left);
                        queue.offer(poll.right);
                    }
                }
            }
            return sb.substring(0, sb.length() - 1) + "]";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) {
                return null;
            }
            List<Integer> valueList = Arrays.stream(data.substring(1, data.length() - 1).split(",")).map(i -> "null".equals(i) ? null : Integer.valueOf(i)).collect(Collectors.toList());
            TreeNode root = new TreeNode(valueList.get(0));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (2 * index + 2 < valueList.size()) {
                        Integer left = valueList.get(2 * index + 1);
                        Integer right = valueList.get(2 * index + 2);
                        if (left != null) {
                            poll.left = new TreeNode(left);
                            queue.offer(poll.left);
                        }
                        if (right != null) {
                            poll.right = new TreeNode(right);
                            queue.offer(poll.right);
                        }
                        index++;
                    }
                }
            }
            return root;
        }
    }
}
