package leetcode.leetcode202302;

import java.util.Arrays;

public class leetcode_2335 {
    public static void main(String[] args) {
        int[] a=new int[]{5,4,4};
        System.out.println(new leetcode_2335().fillCups(a));
    }
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int ans = 0;

        if(amount[0]+amount[1]<=amount[2]){
            ans=amount[2];
        }else{
            ans= (int) Math.ceil((amount[0]+amount[1]+amount[2])/2.0);
        }

        return ans;
    }
}
