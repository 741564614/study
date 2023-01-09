package leetcode.leetcode202301;

public class leetcode_1806 {
    public int reinitializePermutation(int n) {
        int ans = 1;
        int i = n / 2;
        while(i!=1){
            if(i%2==0){
                i/=2;
            }else{
                i=(n+i-1)/2;
            }
            ans++;
        }

        return ans;
    }
}
