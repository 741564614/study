package leetcode.leetcode202208;

public class leetcode_622 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1); // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear(); // 返回 3
        circularQueue.isFull(); // 返回 true
        circularQueue.deQueue(); // 返回 true
        circularQueue.enQueue(4); // 返回 true
        circularQueue.Rear(); // 返回 4
    }

    static class MyCircularQueue {

        private int[] value;
        int size,front,rear;

        public MyCircularQueue(int k) {
            value=new int[k+1];
            size = k+1;
            front=0;
            rear=0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            this.value[rear]=value;
            rear=(rear+1)%size;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            front=(front+1)%size;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : this.value[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : this.value[(rear-1+size)%size];
        }

        public boolean isEmpty() {
            return front==rear;
        }

        public boolean isFull() {
            return front==(rear+1)%size;
        }
    }

     static class  MyCircularQueue2 {

        private int[] value;
        int size,front,rear;

        public MyCircularQueue2(int k) {
            value=new int[k+1];
            size = k+1;
            front=0;
            rear=0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            this.value[rear%size]=value;
            rear++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            front++;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : this.value[front%size];
        }

        public int Rear() {
            return isEmpty() ? -1 : this.value[(rear-1)%size];
        }

        public boolean isEmpty() {
            return front==rear;
        }

        public boolean isFull() {
            return front==(rear+1)%size;
        }
    }
}
