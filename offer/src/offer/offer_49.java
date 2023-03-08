package offer;

import java.util.*;

public class offer_49 {

    public static void main(String[] args) {
        System.out.println(new offer_49().nthUglyNumber(1407));
    }

    public int nthUglyNumber02(int n) {
        int[] m = new int[]{2, 3, 5};
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        set.add(1L);
        priorityQueue.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = priorityQueue.poll();
            ugly = (int) cur;
            for (int mx : m) {
                long next = mx * cur;
                if (!set.contains(next)) {
                    set.add(next);
                    priorityQueue.offer(next);
                }
            }
        }
        return ugly;
    }

    public int nthUglyNumber(int n) {
        TreeSet<Long> treeSet = new TreeSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);
        int[] nums = new int[]{2, 3, 5};
        Set<Long> set = new HashSet<>();
        set.add(1L);
        while (treeSet.size() < n) {
            Long poll = queue.poll();
            for (int num : nums) {
                if (!set.contains(poll * num)) {
                    queue.offer(poll * num);
                    set.add(poll * num);
                }
            }
            treeSet.add(poll);
        }
        return treeSet.toArray(new Long[0])[n - 1].intValue();
    }

    public int nthUglyNumber03(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 0, p3 = 0, p5 = 0, p = 0;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n];
        // 开始合并三个有序链表，找到第 n 个丑数时结束
        while (p < n) {
            // 取三个链表的最小结点
            int min = Math.min(Math.min(product2, product3), product5);
            // 将最小节点接到结果链表上
            ugly[p++] = min;
            // 前进对应有序链表上的指针
            if (min == product2) {
                product2 = 2 * ugly[p2++];
            }
            if (min == product3) {
                product3 = 3 * ugly[p3++];
            }
            if (min == product5) {
                product5 = 5 * ugly[p5++];
            }
        }
        return ugly[n - 1];
    }
}
