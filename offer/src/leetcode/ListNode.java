package leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode init(int[] values) {
        ListNode root = new ListNode(-1);
        ListNode ans = root;
        for (int value : values) {
            ans.next = new ListNode(value);
            ans = ans.next;
        }
        return root.next;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
