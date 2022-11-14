package leetcode.leetcode202211;

import java.util.*;

public class leetcode_805 {
    public boolean splitArraySameAverage02(int[] nums) {
        int n = nums.length, m = n / 2, sum = 0;
        for (int x : nums) sum += x;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int s = 0; s < (1 << m); s++) {
            int tot = 0, cnt = 0;
            for (int i = 0; i < m; i++) {
                if (((s >> i) & 1) == 1) {
                    tot += nums[i]; cnt++;
                }
            }
            Set<Integer> set = map.getOrDefault(tot, new HashSet<>());
            set.add(cnt);
            map.put(tot, set);
        }
        for (int s = 0; s < (1 << (n - m)); s++) {
            int tot = 0, cnt = 0;
            for (int i = 0; i < (n - m); i++) {
                if (((s >> i) & 1) == 1) {
                    tot += nums[i + m]; cnt++;
                }
            }
            for (int k = Math.max(1, cnt); k < n; k++) {
                if (k * sum % n != 0) continue;
                int t = k * sum / n;
                if (!map.containsKey(t - tot)) continue;
                if (!map.get(t - tot).contains(k - cnt)) continue;
                return true;
            }
        }
        return false;
    }

    int[] nums;
    int[] sums;

    public boolean splitArraySameAverage03(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return false;

        Arrays.sort(nums);
        sums = new int[len+1];
        for (int i=0; i<len; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        int sum = sums[len];

        this.nums = nums;

        for (int i=1, stop=len/2; i<=stop; i++) {
            if ( (sum*i) % len == 0
                    && findSum(i, len, (sum*i)/len) )
                return true;
        }

        return false;

    }

    boolean findSum(int k, int pos, int target) {
        //System.out.format("findSum(%d,%d,%d)\n",k,pos,target);
        if (k == 1) {
            while (nums[--pos] > target) {}
            return nums[pos] == target;
        }

        for (int i=pos; sums[i]-sums[i-- -k] >= target; ) {
            if (sums[k-1] <= target-nums[i] && findSum(k-1, i, target-nums[i]))
                return true;
        }

        return false;
    }
}
