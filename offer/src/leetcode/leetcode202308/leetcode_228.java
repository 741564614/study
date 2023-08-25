package leetcode.leetcode202308;

import java.util.ArrayList;
import java.util.List;

public class leetcode_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length==0){
            return ans;
        }
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                ans.add(nums[i - 1] == prev ? prev + "" : prev + "->" + nums[i - 1]);
                prev = nums[i];
            }
        }
        ans.add(nums[nums.length-1] == prev ? prev + "" : prev + "->" + nums[nums.length-1]);
        return ans;
    }


    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            int len = nums.length;
            if (len == 0) {
                return ans;
            }
            int i = 0;
            int j = 0;
            while (i < len) {
                j = i;
                while ((j + 1 < len) && (nums[j + 1] == nums[j] + 1)) {
                    j += 1;
                }
                StringBuilder sb = new StringBuilder();
                if (i == j) {
                    sb.append(nums[i]);
                } else {
                    sb.append(nums[i]).append("->").append(nums[j]);
                }
                ans.add(sb.toString());
                i = j + 1;
            }
            return ans;
        }

    }
}
