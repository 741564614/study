package leetcode.leetcode202304;

public class leetcode_1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = getMax(firstLen, secondLen, n, prefix, max, i);
            max = getMax(secondLen, firstLen, n, prefix, max, i);
        }
        return max;
    }

    private int getMax(int firstLen, int secondLen, int n, int[] prefix, int max, int i) {
        if (i < (n - firstLen + 1)) {
            for (int j = i + firstLen; j < n - secondLen + 1; j++) {
                max = Math.max(max, prefix[i + firstLen] - prefix[i] + prefix[j + secondLen] - prefix[j]);
            }
        }
        return max;
    }

    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            for(int i=1;i<nums.length;i++){
                nums[i]+=nums[i-1];//前缀和
            }
            int res = nums[firstLen+secondLen-1];
            int fmax = nums[firstLen-1];
            int smax = nums[secondLen-1];
            for(int i=firstLen+secondLen;i<nums.length;i++){
                fmax = Math.max(fmax,nums[i-secondLen]-nums[i-firstLen-secondLen]);
                smax = Math.max(smax,nums[i-firstLen]-nums[i-firstLen-secondLen]);
                res = Math.max(res,Math.max(fmax+nums[i]-nums[i-secondLen],smax+nums[i]-nums[i-firstLen]));
            }
            return res;
        }
    }
}
