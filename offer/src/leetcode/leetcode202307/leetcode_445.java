package leetcode.leetcode202307;

import leetcode.ListNode;

import java.util.*;

public class leetcode_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Map<ListNode, ListNode> prevMap = new HashMap<>();
        ListNode head1 = l1, head2 = l2;
        while (head1 != null && head2 != null) {
            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1 == null) {
            ListNode temp = l2;
            l2 = l1;
            l1 = temp;
            head1 = head2;
        }

        head2 = l1;
        while (head1 != null) {
            l1 = l1.next;
            head1 = head1.next;
        }

        head1 = head2;
        while (head2.next != null) {
            prevMap.putIfAbsent(head2.next, head2);
            head2 = head2.next;
        }
        int j = 0;
        while (l1 != null) {
            int value = l1.val + l2.val;
            l1.val = value % 10;
            j = value / 10;
            ListNode temp = l1;
            while (j != 0) {
                if (prevMap.containsKey(temp)) {
                    int v = prevMap.get(temp).val + j;
                    prevMap.get(temp).val = v % 10;
                    j = v / 10;
                    temp = prevMap.get(temp);
                } else {
                    ListNode newRoot = new ListNode(1);
                    newRoot.next = temp;
                    prevMap.putIfAbsent(temp, newRoot);
                    head1 = newRoot;
                    j=0;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return head1;
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverseList(l1);
            l2 = reverseList(l2); // l1 和 l2 反转后，就变成【2. 两数相加】了
            ListNode l3 = addTwo(l1, l2, 0);
            return reverseList(l3);
        }

        private ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode newHead = reverseList(head.next);
            head.next.next = head; // 把下一个节点指向自己
            head.next = null; // 断开指向下一个节点的连接，保证最终链表的末尾节点的 next 是空节点
            return newHead;
        }

        // l1 和 l2 为当前遍历的节点，carry 为进位
        private ListNode addTwo(ListNode l1, ListNode l2, int carry) {
            if (l1 == null && l2 == null) // 递归边界：l1 和 l2 都是空节点
                return carry != 0 ? new ListNode(carry) : null; // 如果进位了，就额外创建一个节点
            if (l1 == null) { // 如果 l1 是空的，那么此时 l2 一定不是空节点
                l1 = l2;
                l2 = null; // 交换 l1 与 l2，保证 l1 非空，从而简化代码
            }
            carry += l1.val + (l2 != null ? l2.val : 0); // 节点值和进位加在一起
            l1.val = carry % 10; // 每个节点保存一个数位
            l1.next = addTwo(l1.next, (l2 != null ? l2.next : null), carry / 10); // 进位
            return l1;
        }
    }

}
