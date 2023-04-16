package leetcode.leetcode202304;

import java.util.Comparator;
import java.util.*;

public class leetcode_1157 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 1, 2, 2, 1, 1, 2, 1, 2, 1, 1, 2, 2, 1, 2};
        MajorityChecker m = new MajorityChecker(arr);
        System.out.println(m.query(3, 7, 4));
    }

    static class MajorityChecker {
        private int n;
        private int[] arr;
        private Map<Integer, List<Integer>> loc;
        private Node[] tree;

        public MajorityChecker(int[] arr) {
            this.n = arr.length;
            this.arr = arr;
            this.loc = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < arr.length; ++i) {
                loc.putIfAbsent(arr[i], new ArrayList<Integer>());
                loc.get(arr[i]).add(i);
            }

            this.tree = new Node[n * 4];
            for (int i = 0; i < n * 4; i++) {
                tree[i] = new Node();
            }
            segBuild(0, 0, n - 1);
        }

        public int query(int left, int right, int threshold) {
            Node ans = new Node();
            segQuery(0, 0, n - 1, left, right, ans);
            List<Integer> pos = loc.getOrDefault(ans.x, new ArrayList<Integer>());
            int occ = searchEnd(pos, right) - searchStart(pos, left);
            return occ >= threshold ? ans.x : -1;
        }

        private void segBuild(int id, int l, int r) {
            if (l == r) {
                tree[id] = new Node(arr[l], 1);
                return;
            }

            int mid = (l + r) / 2;
            segBuild(id * 2 + 1, l, mid);
            segBuild(id * 2 + 2, mid + 1, r);
            tree[id].add(tree[id * 2 + 1]);
            tree[id].add(tree[id * 2 + 2]);
        }

        private void segQuery(int id, int l, int r, int ql, int qr, Node ans) {
            if (l > qr || r < ql) {
                return;
            }
            if (ql <= l && r <= qr) {
                ans.add(tree[id]);
                return;
            }

            int mid = (l + r) / 2;
            segQuery(id * 2 + 1, l, mid, ql, qr, ans);
            segQuery(id * 2 + 2, mid + 1, r, ql, qr, ans);
        }

        private int searchStart(List<Integer> pos, int target) {
            int low = 0, high = pos.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (pos.get(mid) >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private int searchEnd(List<Integer> pos, int target) {
            int low = 0, high = pos.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (pos.get(mid) > target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        class Node {
            int x;
            int cnt;

            public Node() {
                this(0, 0);
            }

            public Node(int x, int cnt) {
                this.x = x;
                this.cnt = cnt;
            }

            public void add(Node that) {
                if (x == that.x) {
                    cnt += that.cnt;
                } else if (cnt >= that.cnt) {
                    cnt -= that.cnt;
                } else {
                    x = that.x;
                    cnt = that.cnt - cnt;
                }
            }
        }
    }



    static class MajorityChecker02 {

        int n;
        int[][] cnt;
        int[] arr;

        public MajorityChecker02(int[] arr) {
            n = arr.length;
            this.arr = arr;
            cnt = new int[n + 1][16];
            for (int i = 1; i < n + 1; i++) {
                for (int k = 0; k < 16; k++) {
                    cnt[i][k] = ((arr[i - 1] & (1 << k)) != 0 ? 1 : 0) + cnt[i - 1][k];
                }
            }
        }

        public int query(int left, int right, int threshold) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 15; k >= 0; k--) {
                stringBuilder.append(cnt[right + 1][k] - cnt[left][k] >= threshold ? "1" : 0);
            }
            int value = Integer.parseInt(stringBuilder.toString(), 2);
            for (int i = left; i <= right; i++) {
                if (arr[i] == value) {
                    threshold--;
                }
            }
            return threshold > 0 ? -1 : value;
        }

    }
}
