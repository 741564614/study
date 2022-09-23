package leetcode.leetcode202209;

public class leetcode_707 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3, 0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        linkedList.get(4);
    }

    class MyLinkedList02 {
        int size;
        ListNode head;
        ListNode tail;
        public MyLinkedList02() {
            size = 0;
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if(index < 0 || index >= size) return -1;
            ListNode curr;
            if(index + 1 < size - index){
                curr = head;
                for(int i = 0;i <= index;i++)
                    curr = curr.next;
            }else{
                curr = tail;
                for(int i = 0;i < size-index;i++)
                    curr = curr.prev;
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            ListNode curr = new ListNode(val);
            ++size;
            ListNode ne = head,pre = head.next;
            ne.next = curr;
            curr.prev = ne;
            curr.next = pre;
            pre.prev = curr;
        }

        public void addAtTail(int val) {
            ListNode curr = new ListNode(val);
            ++size;
            ListNode pre = tail,ne = tail.prev;
            curr.next = pre;
            curr.prev = ne;
            ne.next = curr;
            pre.prev = curr;
        }

        public void addAtIndex(int index, int val) {
            if(index < 0) index = 0;
            if(index > size) return;
            ListNode ne,pre;
            ListNode temp = new ListNode(val);
            if(index < size/2){
                ne = head;
                for(int i = 0;i < index;++i)
                    ne = ne.next;
                pre = ne.next;
            }else{
                pre = tail;
                for(int i = 0;i < size-index;++i)
                    pre = pre.prev;
                ne = pre.prev;
            }
            ++size;
            ne.next = temp;
            temp.prev = ne;
            temp.next = pre;
            pre.prev = temp;
        }

        public void deleteAtIndex(int index) {
            if(index < 0 || index >= size) return;
            ListNode ne,pre;
            if(index < size/2){
                ne = head;
                for(int i = 0;i < index;++i)
                    ne = ne.next;
                pre =ne.next.next;
            }else{
                pre = tail;
                for(int i = 0;i < size-index-1;++i)
                    pre = pre.prev;
                ne = pre.prev.prev;
            }
            --size;
            ne.next = pre;
            pre.prev = ne;
        }
        class ListNode{
            int val;
            ListNode next;
            ListNode prev;
            public ListNode(int val){
                this.val  = val;
            }
        }
    }


    static class MyLinkedList {

        public Node root;
        public int size;

        public MyLinkedList() {
            root = new Node(null, null, -1);
            size = 0;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            Node temp = root;
            while (index + 1 > 0) {
                temp = temp.next;
                index--;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            Node temp = root.next;
            root.next = new Node(root, temp, val);
            if (temp != null) {
                temp.prev = root.next;
            }
            size++;
        }

        public void addAtTail(int val) {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(temp, null, val);
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            Node temp = root;
            while (index + 1 > 0) {
                temp = temp.next;
                index--;
            }
            Node prev = temp.prev;
            prev.next = new Node(prev, temp, val);
            temp.prev = prev.next;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }
            Node temp = root;
            while (index + 1 > 0) {
                temp = temp.next;
                index--;
            }
            Node prev = temp.prev;
            Node next = temp.next;
            prev.next = next;
            if (next != null) {
                next.prev = prev;
            }
            size--;
        }

        class Node {
            Node prev;
            Node next;
            int val;

            public Node(Node prev, Node next, int val) {
                this.prev = prev;
                this.next = next;
                this.val = val;
            }

            public Node getPrev() {
                return prev;
            }

            public void setPrev(Node prev) {
                this.prev = prev;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public int getVal() {
                return val;
            }

            public void setVal(int val) {
                this.val = val;
            }
        }
    }


}
