package leetcode.leetcode202212;

import java.util.Arrays;

public class leetcode_1775 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 5, 5, 2, 1, 1, 1, 1, 4, 4, 4, 1, 5, 2, 2, 4, 6, 5, 1, 5, 3, 5, 6, 2, 3, 1, 5, 4, 4, 1, 2, 4, 1, 1, 6, 3, 6, 4, 4, 4, 3, 5, 5, 5, 2, 6, 4, 2, 5, 4, 2, 6, 3, 4, 6, 1, 5, 3, 2, 3, 5, 2, 1, 3, 2, 4, 4, 4, 5, 3, 5, 5, 4, 1, 1, 6, 5, 6, 3, 5, 3, 6, 5, 6, 5, 4, 4, 4, 5, 6, 6, 6, 4, 2, 4, 6, 1, 2, 1, 5, 3, 4, 5, 5, 6, 6, 1, 4, 3, 1, 5, 3, 4, 1, 2, 1, 4, 4, 5, 6, 5, 3, 1, 5, 1, 3, 3, 6, 5, 3, 5, 6, 2, 6, 3, 1, 2, 3, 3, 1, 1, 4, 3, 2, 6, 6, 2, 1, 2, 4, 3, 5, 5, 4, 3, 1, 1, 5, 2, 5, 1, 4, 5, 6, 4, 5, 2, 1, 2, 5, 3, 2, 6, 3, 4, 3, 4, 5, 4, 6, 3, 4, 4, 3, 3, 4, 2, 2, 6, 2, 6, 3, 1, 1, 5, 3, 1, 1, 4, 2, 5, 5, 5, 4, 3, 6, 5, 5, 5, 1, 1, 3, 6, 2, 3, 6, 3, 4, 2, 5, 4, 4, 3, 5, 6, 4, 3, 5, 1, 1, 3, 3, 1, 1, 6, 4, 6, 2, 1, 4, 3, 5, 5};

        int[] ints2 = new int[]{1, 2, 5, 4, 3, 3, 5, 1, 1, 6, 2, 5, 4, 4, 5, 6, 6, 4, 2, 5, 6, 2, 3, 4, 5, 2, 4, 4, 3, 6, 6, 5, 4, 1, 2, 1, 2, 3, 3, 2, 6, 1, 1, 1, 1, 3, 5, 6, 2, 1, 1, 1, 4, 6, 5};
        System.out.println(new leetcode_1775().minOperations(ints, ints2));
    }

    public int minOperations(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (Math.max(n1, n2) > Math.min(n1, n2) * 6) {
            return -1;
        }

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            if (i < n1) {
                sum1 += nums1[i];
            }
            if (i < n2) {
                sum2 += nums2[i];
            }
        }

        int sum = Math.abs(sum1 - sum2);

        if (sum == 0) {
            return 0;
        }

        int ans = 0;

        if (sum1 > sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int i = 0, j = 0;
        while (sum > 0) {
            if (i < nums1.length && nums1[i] != 6 && j < nums2.length && nums2[nums2.length - 1 - j] != 1) {
                sum -= Math.max(6 - nums1[i], nums2[nums2.length - 1 - j] - 1);
                ans++;
                if(6 - nums1[i]>nums2[nums2.length - 1 - j] - 1){
                    i++;
                }else{
                    j++;
                }
            } else if (j < nums2.length && nums2[nums2.length - 1 - j] != 1) {
                sum -= (nums2[nums2.length - 1 - j] - 1);
                ans++;
                j++;
            } else if (i < nums1.length && nums1[i] != 6) {
                sum -= (6 - nums1[i++]);
                ans++;
            }
        }

        return ans;
    }

    public int minOperations02(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (6 * n < m || 6 * m < n) {
            return -1;
        }
        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];
        int diff = 0;
        for (int i : nums1) {
            ++cnt1[i];
            diff += i;
        }
        for (int i : nums2) {
            ++cnt2[i];
            diff -= i;
        }
        if (diff == 0) {
            return 0;
        }
        if (diff > 0) {
            return help(cnt2, cnt1, diff);
        }
        return help(cnt1, cnt2, -diff);
    }

    public int help(int[] h1, int[] h2, int diff) {
        int[] h = new int[7];
        for (int i = 1; i < 7; ++i) {
            h[6 - i] += h1[i];
            h[i - 1] += h2[i];
        }
        int res = 0;
        for (int i = 5; i > 0 && diff > 0; --i) {
            int t = Math.min((diff + i - 1) / i, h[i]);
            res += t;
            diff -= t * i;
        }
        return res;
    }

}
