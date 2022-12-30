package leetcode.leetcode202212;

import java.util.*;

public class leetcode_855 {
    public static void main(String[] args) {

        boolean[] k = new boolean[(int) Math.pow(10, 9)];
        String[] method = {"ExamRoom", "seat", "seat", "seat", "leave", "leave", "seat", "seat", "seat", "seat", "seat", "seat", "seat", "seat", "seat", "leave", "leave", "seat", "seat", "leave", "seat", "leave", "seat", "leave", "seat", "leave", "seat", "leave", "leave", "seat", "seat", "leave", "leave", "seat", "seat", "leave"};
        int[][] arg = new int[][]{{10}, {}, {}, {}, {0}, {4}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {0}, {4}, {}, {}, {7}, {}, {3}, {}, {3}, {}, {9}, {}, {0}, {8}, {}, {}, {0}, {8}, {}, {}, {2}};
        ExamRoom examRoom = new ExamRoom(arg[0][0]);
        for (int i = 1; i < method.length; i++) {
            if (method[i].equals("seat")) {
                System.out.println(examRoom.seat());
            } else {
                examRoom.leave(arg[i][0]);
            }
        }
    }
    class ExamRoom20 {
        int n;
        TreeSet<Integer> seats;
        PriorityQueue<int[]> pq;

        public ExamRoom20(int n) {
            this.n = n;
            this.seats = new TreeSet<Integer>();
            this.pq = new PriorityQueue<int[]>((a, b) -> {
                int d1 = a[1] - a[0], d2 = b[1] - b[0];
                return d1 / 2 < d2 / 2 || (d1 / 2 == d2 / 2 && a[0] > b[0]) ? 1 : -1;
            });
        }

        public int seat() {
            if (seats.isEmpty()) {
                seats.add(0);
                return 0;
            }
            int left = seats.first(), right = n - 1 - seats.last();
            while (seats.size() >= 2) {
                int[] p = pq.peek();
                if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) { // 不属于延迟删除的区间
                    int d = p[1] - p[0];
                    if (d / 2 < right || d / 2 <= left) { // 最左或最右的座位更优
                        break;
                    }
                    pq.poll();
                    pq.offer(new int[]{p[0], p[0] + d / 2});
                    pq.offer(new int[]{p[0] + d / 2, p[1]});
                    seats.add(p[0] + d / 2);
                    return p[0] + d / 2;
                }
                pq.poll(); // leave 函数中延迟删除的区间在此时删除
            }
            if (right > left) { // 最右的位置更优
                pq.offer(new int[]{seats.last(), n - 1});
                seats.add(n - 1);
                return n - 1;
            } else {
                pq.offer(new int[]{0, seats.first()});
                seats.add(0);
                return 0;
            }
        }

        public void leave(int p) {
            if (p != seats.first() && p != seats.last()) {
                int prev = seats.lower(p), next = seats.higher(p);
                pq.offer(new int[]{prev, next});
            }
            seats.remove(p);
        }
    }


    static class ExamRoom {
        private int n;
        private List<int[]> priorityQueue;
        private Map<Integer, Boolean> check;

        public ExamRoom(int n) {
            check = new HashMap<>();
            this.n = n;
            priorityQueue = new ArrayList<>();
            priorityQueue.add(new int[]{0, n - 1});
        }

        public int seat() {
            int[] poll = priorityQueue.remove(0);
            int ans = 0;
            if (!check.getOrDefault(poll[0], false)) {
                ans = poll[0];
                check.put(ans, true);
                priorityQueue.add(poll);
            } else if (!check.getOrDefault(poll[1], false)) {
                ans = poll[1];
                check.put(ans, true);
                priorityQueue.add(poll);
            } else {
                ans = (poll[1] - poll[0]) / 2 + poll[0];
                check.put(ans, true);
                priorityQueue.add(new int[]{poll[0], ans});
                priorityQueue.add(new int[]{ans, poll[1]});
            }

            this.sort();
            return ans;
        }

        public void sort() {
            Collections.sort(priorityQueue, (a, b) -> {
                int k = check.getOrDefault(a[0], false) && check.getOrDefault(a[1], false) ? (a[1] - a[0]) / 2 : a[1] - a[0];
                int j = check.getOrDefault(b[0], false) && check.getOrDefault(b[1], false) ? (b[1] - b[0]) / 2 : b[1] - b[0];
                if (k == j) {
                    return a[0] - b[0];
                }
                return j > k ? 1 : -1;
            });

        }

        public void leave(int p) {
            check.put(p, false);
            List<int[]> removeList = new ArrayList<>();
            int[] addArr = new int[2];
            if (p != 0 && p != n - 1) {
                priorityQueue.forEach(item -> {
                    if (item[0] == p || item[1] == p) {
                        removeList.add(item);
                        if (item[0] == p) {
                            addArr[1] = item[1];
                        } else {
                            addArr[0] = item[0];
                        }
                    }
                });

                priorityQueue.removeAll(removeList);
                priorityQueue.add(addArr);

            }

            this.sort();

        }
    }
}
