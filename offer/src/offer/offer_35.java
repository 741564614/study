package offer;

import leetcode.Node;

import java.util.HashMap;
import java.util.Map;

public class offer_35 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node root = new Node(-1);
        root.next = new Node(head.val);
        Node newHead = root.next;
        Node oldHead = head;
        Map<Node, Node> map = new HashMap<>();
        while (oldHead != null) {
            map.putIfAbsent(oldHead, newHead);
            if (oldHead.next != null) {
                newHead.next = new Node(oldHead.next.val);
            }
            newHead = newHead.next;
            oldHead = oldHead.next;
        }

        oldHead = head;
        newHead = root.next;
        while (oldHead != null) {
            newHead.random = map.getOrDefault(oldHead.random, null);
            newHead = newHead.next;
            oldHead = oldHead.next;
        }
        return root.next;
    }

    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList20(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList20(head.next);
            headNew.random = copyRandomList20(head.random);
        }
        return cachedNode.get(head);
    }
}
