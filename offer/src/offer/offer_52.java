package offer;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class offer_52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headC = new ListNode(8);
        headC.next = new ListNode(4);
        headC.next.next = new ListNode(5);
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = headC;
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headC;
        System.out.println(new offer_52().getIntersectionNode02(headA, headB));
    }

    /**
     * 两边同步移动，待到自己结尾时转移去另一个链表开头，等于将两个链表拼接起来
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode02(ListNode headA, ListNode headB) {
        boolean changeA = false, changeB = false;
        ListNode rootA = headA, rootB = headB;
        while (headA != null && headB != null && headA != headB) {
            if (headA.next == null && !changeA) {
                headA = rootB;
                changeA = true;
            } else {
                headA = headA.next;
            }
            if (headB.next == null && !changeB) {
                headB = rootA;
                changeB = true;
            } else {
                headB = headB.next;
            }
        }
        return headA != null && headB != null ? headA : null;
    }

    /**
     * 先分别遍历，然后移动指针，使得两个链表的指针距离结尾距离相等，再同步移动
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode03(ListNode headA, ListNode headB) {
        ListNode rootA = headA, rootB = headB;
        int lengthA = 0, lengthB = 0;
        while (headA != null) {
            headA = headA.next;
            lengthA++;
        }
        while (headB != null) {
            headB = headB.next;
            lengthB++;
        }


        headA = rootA;
        headB = rootB;
        while (lengthB != 0 && lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        while (lengthA != 0 && lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA != null && headB != null ? headA : null;
    }
}
