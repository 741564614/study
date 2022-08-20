package leetcode.leetcode202208;

public class leetcode_1413 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,5,-5,-1};
        System.out.println(minStartValue(nums));
    }
    public static int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum=0;
        for(int n:nums){
            sum+=n;
            min=Math.min(min,sum);
        }
        return min>0?1:Math.abs(min)+1;
    }
}
