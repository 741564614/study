package offer;

import java.util.*;

public class offer_41 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
    }

    static class MedianFinder {
        List<Double> list;
        Double median;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            list = new ArrayList<>();
            median = 0d;
        }

        public void addNum(int num) {
            if (list.isEmpty()) {
                list.add((double) num);
            } else {
                int l = 0, r = list.size();
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (list.get(mid) <= num) {
                        l = mid + 1;
                    } else if (list.get(mid) > num) {
                        r = mid;
                    }
                }
                list.add(l, (double) num);
            }
            if (list.size() % 2 == 0) {
                double a = list.get(list.size() / 2 - 1);
                double b = list.get(list.size() / 2);
                median = (a + b) / 2;
            } else {
                median = list.get(list.size() / 2);
            }
        }

        public double findMedian() {
            return median;
        }
    }

    class MedianFinder02 {
        Queue<Integer> A, B;
        public MedianFinder02() {
            A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
        }
        public void addNum(int num) {
            if(A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }
        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }
}
