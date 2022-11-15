package leetcode.leetcode202211;

import java.util.Arrays;

public class leetcode_1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int[] boxType : boxTypes) {
            int num = Math.min(boxType[0], truckSize);
            ans += (num * boxType[1]);
            truckSize -= num;
            if (truckSize == 0) {
                break;
            }
        }
        return ans;
    }

    public int maximumUnits02(int[][] boxTypes, int truckSize) {
        int[]ans=new int[1001];
        for(int[]box:boxTypes){
            ans[box[1]]+=box[0];
        }
        int count=0;
        for(int i=ans.length-1;i>0;i--){
            if(ans[i]!=0){
                if(truckSize>ans[i]){
                    count+=(ans[i]*i);
                    truckSize-=ans[i];
                }else{
                    count+=(i*truckSize);
                    return count;
                }
            }
        }
        return count;
    }
}
