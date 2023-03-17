package offer;

import java.util.Arrays;

public class offer_56_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 3, 3};
        System.out.println(new offer_56_2().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    class Solution {
        public int singleNumber(int[] nums) {
            int[] counts = new int[32];
            for(int num : nums) {
                for(int j = 0; j < 32; j++) {
                    counts[j] += num & 1;
                    num >>>= 1;
                }
            }
            int res = 0, m = 3;
            for(int i = 0; i < 32; i++) {
                res <<= 1;
                res |= counts[31 - i] % m;
            }
            return res;
        }
    }

    class Solution02 {
        public int singleNumber(int[] nums) {
            int ones = 0, twos = 0;
            for(int num : nums){
                ones = ones ^ num & ~twos;
                twos = twos ^ num & ~ones;
            }
            return ones;
        }
    }


}
