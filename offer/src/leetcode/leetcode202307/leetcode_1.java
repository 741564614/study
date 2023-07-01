package leetcode.leetcode202307;

import java.util.*;

public class leetcode_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) {
                ans[0] = i;
                ans[1] = map.get(other);
                break;
            }
        }
        return ans;
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                int t=target-nums[i];
                if(map.containsKey(t)){
                    return new int[]{map.get(t),i};
                }
                map.put(nums[i],i);
            }
            return new int[2];
        }
    }
}
