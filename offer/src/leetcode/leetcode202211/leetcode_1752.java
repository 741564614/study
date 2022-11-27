package leetcode.leetcode202211;

public class leetcode_1752 {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0, prev = nums[0];
        for (int i = 0; i < 2 * n; i++) {
            if (prev <= nums[i % n]) {
                count++;
            }else{
                count=1;
            }
            if(count==n){
                return true;
            }
            prev = nums[i % n];
        }
        return false;
    }
}
