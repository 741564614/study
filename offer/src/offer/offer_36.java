package offer;

public class offer_36 {

    public static void main(String[] args) {
        Node root=new Node(4);
        root.right=new Node(5);
        root.left=new Node(2);
        root.left.left=new Node(1);
        root.left.right=new Node(3);
    }

    public Node treeToDoublyList(Node root) {
        Node head = root;
        Node tail = root;
        while (head.left != null) {
            head = head.left;
        }
        while (tail.right != null) {
            tail = tail.right;
        }
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public Node dfs(Node root) {
        if (root == null) {
            return null;
        }
        Node left = dfs(root.left);
        if(left!=null){
            while(left.right!=null){
                left=left.right;
            }
            root.left = left;
            left.right = root;
        }
        Node right = dfs(root.right);
        if(right!=null){
            while(right.left!=null){
                right=right.left;
            }
            root.right = right;
            right.left = root;
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        Node pre, head;
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }
        void dfs(Node cur) {
            if(cur == null) return;
            dfs(cur.left);
            if(pre != null) pre.right = cur;
            else head = cur;
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }
    }
}
