package leetcode.leetcode202212;

import java.util.ArrayList;

public class leetcode_1703 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,1,0,1,1,1,0,1,1};
        System.out.println(new leetcode_1703().minMoves(nums, 7));
    }

    public int minMoves02(int[] nums, int k) {
        var p = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] != 0) p.add(i - p.size());
        int m = p.size();
        int[] s = new int[m + 1]; // p 的前缀和
        for (int i = 0; i < m; i++)
            s[i + 1] = s[i] + p.get(i);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; ++i) // p[i] 到 p[i+k-1] 中所有数到 p[i+k/2] 的距离之和，取最小值
            ans = Math.min(ans, s[i] + s[i + k] - s[i + k / 2] * 2 - p.get(i + k / 2) * (k % 2));
        return ans;
    }

    public int minMoves(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int start = i;
                while (i < nums.length && nums[i] == 1) {
                    i++;
                }
                int p = k - (i - start);
                min = Math.min(min, count(nums, start, i - 1, p));
            }
        }
        return min;
    }

    public int count(int[] nums, int l, int r, int k) {
        int start = l - 1, end = r + 1, ans = 0;
        while (k > 0 && (start >= 0 || end <= nums.length - 1)) {

            while (start >= 0 && nums[start] == 0) {
                start--;
            }

            while (end <= nums.length - 1 && nums[end] == 0) {
                end++;
            }

            if (start >= 0 && end <= nums.length - 1) {
                k--;
                if (end - r - 1 < l - start - 1) {
                    ans += (end - r - 1);
                    r++;
                    end++;
                } else {
                    ans += (l - start - 1);
                    l--;
                    start--;
                }
            }else if(start>=0){
                k--;
                ans += (l - start - 1);
                l--;
                start--;
            }else if(end<=nums.length-1){
                k--;
                ans += (end - r - 1);
                r++;
                end++;
            }
        }
        return ans;
    }
}
