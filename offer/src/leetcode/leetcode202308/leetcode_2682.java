package leetcode.leetcode202308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_2682 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new leetcode_2682().circularGameLosers(6, 1)));
    }

    public int[] circularGameLosers(int n, int k) {
        int[] cnt = new int[n];
        int i = 0, turn = 1;
        while (true) {
            cnt[i]++;
            if (cnt[i] > 1) {
                break;
            }
            i = (i + turn * k) % n;
            turn++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < cnt.length; j++) {
            if (cnt[j] == 0) {
                ans.add(j + 1);
            }
        }
        return ans.stream().mapToInt(a -> a).toArray();
    }
    class Solution {
        public int[] circularGameLosers(int n, int k) {
            int[] dao = new int[n];
            int ptr=0,times=0;
            while (dao[ptr]==0){
                dao[ptr]=1;
                times++;
                ptr = (ptr+times*k)%n;
            }
            ptr=0;
            int[] ans = new int[n-times];
            for (int i=0;i<n;i++){
                if(dao[i]==0) ans[ptr++]=i+1;
            }
            return ans;
        }
    }
}
