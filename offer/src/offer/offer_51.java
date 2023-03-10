package offer;

import java.util.*;

public class offer_51 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println(new offer_51().reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        guibin(nums, 0, nums.length - 1);
        return ans;
    }

    int ans = 0;

    public int[] guibin(int[] nums, int l, int r) {
        if (l == r) {
            return new int[]{nums[l]};
        }
        int mid = l + (r - l) / 2, leftIndex = 0, rightIndex = 0, index = 0;
        int[] left = guibin(nums, l, mid);
        int[] right = guibin(nums, mid + 1, r);
        int[] result = new int[left.length + right.length];
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[index++] = left[leftIndex++];
            } else {
                ans += left.length - leftIndex;
                result[index++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            result[index++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[index++] = right[rightIndex++];
        }
        return result;
    }


    class Solution {
        public int reversePairs(int[] nums) {
            int n = nums.length;
            int[] tmp = new int[n];
            System.arraycopy(nums, 0, tmp, 0, n);
            // 离散化
            Arrays.sort(tmp);
            for (int i = 0; i < n; ++i) {
                nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
            }
            // 树状数组统计逆序对
            BIT bit = new BIT(n);
            int ans = 0;
            for (int i = n - 1; i >= 0; --i) {
                ans += bit.query(nums[i] - 1);
                bit.update(nums[i]);
            }
            return ans;
        }
    }

    class BIT {
        private int[] tree;
        private int n;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        public int query(int x) {
            int ret = 0;
            while (x != 0) {
                ret += tree[x];
                x -= lowbit(x);
            }
            return ret;
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }
    }

}
