package leetcode.leetcode202208;

public class leetcode_641 {
    public static void main(String[] args) {

    }

    class MyCircularDeque {
        private int[] values;
        int size, front, rear;

        public MyCircularDeque(int k) {
            size = k;
            front = rear = 0;
            values = new int[size];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (front != 0) {
                values[--front] = value;
            } else {
                int[] newValues = new int[size];
                int index = 0;
                newValues[index++] = value;
                for (int i = front; i < rear; i++) {
                    newValues[index++] = values[i];
                }
                values = newValues;
                front = 0;
                rear = index;
            }
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            values[rear++] = value;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            int[] newValues = new int[size];
            int index = 0;
            for (int i = front + 1; i < rear; i++) {
                newValues[index++] = values[i];
            }
            values = newValues;
            front = 0;
            rear = index;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            rear--;
            if (isEmpty()) {
                values = new int[size];
                front = rear = 0;
            }
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return values[front];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return values[rear - 1];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return rear == size;
        }
    }

    class MyCircularDeque2 {
        private int[] values;
        int size, front, rear;

        public MyCircularDeque2(int k) {
            size = k + 1;
            front = rear = 0;
            values = new int[size];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (front - 1 + size) % size;
            values[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            values[rear] = value;
            rear = (rear + 1) % size;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % size;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1 + size) % size;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return values[front];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return values[(rear - 1 + size) % size];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return front == (rear + 1) % size;
        }
    }
}
