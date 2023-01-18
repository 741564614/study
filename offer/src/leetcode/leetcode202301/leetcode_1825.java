package leetcode.leetcode202301;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode_1825 {
    class MKAverage {
        int m;
        int k;
        int index;
        int[] value;
        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            value = new int[m];
            index=0;
        }

        public void addElement(int num) {
            value[index%m]=num;
            index++;
        }

        public int calculateMKAverage() {
            if (index < m) {
                return -1;
            }
            int[] copy = Arrays.copyOf(value, m);
            Arrays.sort(copy);
            int sum = 0;
            for (int i = k; i < m - k; i++) {
                sum += copy[i];
            }
            return sum / (m - 2 * k);
        }
    }

    class MKAverage02 {
        // 一个队列 维护最近加入的m个元素；
        // 三个有序可重复元素的集合 TreeMap， 分别保存 最小的k个数，中间的数，最大的k个数;
        // 如何维护这几个数据结构是关键。
        Deque<Integer> que;
        TreeMap<Integer, Integer> low, mid, high;
        int sum; // 存放mid和;
        int m;
        int k;
        int size1; // low中元素的个数
        int size3; // high元素的个数
        public MKAverage02(int m, int k) {
            que = new ArrayDeque<>();
            low = new TreeMap<>();
            mid = new TreeMap<>();
            high = new TreeMap<>();
            sum = 0;
            this.m = m;
            this.k = k;
        }

        public void addElement(int num) {
            que.offer(num); // 把num放入队列;
            if (low.isEmpty() || num <= low.lastKey()) { // 放入对应的有序集合;
                low.merge(num, 1, Integer :: sum);
                ++size1;
            } else if (high.isEmpty() || num >= high.firstKey()) {
                high.merge(num, 1, Integer :: sum);
                ++size3;
            } else {
                mid.merge(num, 1, Integer :: sum);
                sum += num;
            }

            // 开始维护这四个数据结构;
            if (que.size() > m) { // 如果队列元素过多。
                int x = que.poll(); // 弹出最远元素;
                // 在有序集合中删除该元素;
                if (low.containsKey(x)) {
                    if (low.merge(x, -1, Integer :: sum) == 0) {
                        low.remove(x);
                    }
                    --size1;
                } else if (high.containsKey(x)) {
                    if (high.merge(x, -1, Integer :: sum) == 0) {
                        high.remove(x);
                    }
                    --size3;
                } else {
                    if (mid.merge(x, -1, Integer :: sum) == 0) mid.remove(x);
                    sum -= x;
                }
            }

            // 如果low元素过多，把low中最大的加入到mid
            while (size1 > k) {
                int key = low.lastKey();
                if (low.merge(key, -1, Integer :: sum) == 0) {
                    low.remove(key);
                }
                --size1;
                mid.merge(key, 1, Integer :: sum);
                sum += key;
            }
            // 如果high元素过多，把high中最小的加入到mid
            while (size3 > k) {
                int key = high.firstKey();
                if (high.merge(key, -1, Integer :: sum) == 0) {
                    high.remove(key);
                }
                --size3;
                mid.merge(key, 1, Integer :: sum);
                sum += key;
            }

            // 如果low元素不够，且mid充足，把mid最小放到low
            while (size1 < k && !mid.isEmpty()) {
                int key = mid.firstKey();
                if (mid.merge(key, -1, Integer :: sum) == 0) {
                    mid.remove(key);
                }
                sum -= key;
                low.merge(key, 1, Integer :: sum);
                ++size1;
            }
            // 让high元素不够k，且mid充足，把mid最大放到high;
            while (size3 < k && !mid.isEmpty()) {
                int key = mid.lastKey();
                if (mid.merge(key, -1, Integer :: sum) == 0) {
                    mid.remove(key);
                }
                sum -= key;
                high.merge(key, 1, Integer :: sum);
                ++size3;
            }
        }

        public int calculateMKAverage() {
            return que.size() < m ? -1 : sum / (m - 2 * k);
        }
    }
}
