import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_1403 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,23,5,9,10};
        System.out.println(minSubsequence(nums));
    }
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums.length==1){
            result.add(nums[0]);
            return result;
        }
        Arrays.sort(nums);
        int sum =0;
        for(int b:nums){
            sum+=b;
        }
        int resultSum=0;
        int i=nums.length-1;
        while(resultSum<=sum){
            result.add(nums[i]);
            sum-=nums[i];
            resultSum+=nums[i];
            i--;
        }
        return result;
    }
    public  static List<Integer> minSubsequence1(int[] nums) {
        int sumLeft = 0, sumTake = 0;
        List<Integer> ans = new ArrayList<>();
        int[] numsCnt = new int[101];
        for (int i: nums) {numsCnt[i]++; sumLeft += i;}
        for (int i = 100; i > 0;) {
            if (numsCnt[i] == 0) {--i; continue;}
            if (sumTake > sumLeft) break;
            sumTake += i; sumLeft -= i; numsCnt[i]--;
            ans.add(i);
        }
        return ans;
    }

    public static List<Integer> minSubsequence2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, cur = 0, idx = nums.length - 1;
        for (int i : nums) sum += i;
        List<Integer> ans = new ArrayList<>();
        while (cur <= sum) {
            sum -= nums[idx];
            cur += nums[idx];
            ans.add(nums[idx--]);
        }
        return ans;
    }

}
