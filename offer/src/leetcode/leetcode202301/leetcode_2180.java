package leetcode.leetcode202301;

public class leetcode_2180 {

    public int countEven(int num) {
        int ans=0;
        for(int i=1;i<=num;i++){
            if(check(i)){
                ans++;
            }
        }
        return ans;
    }

    public boolean check(int num){
        int ans=0;
        while(num>0){
            ans+=num%10;
            num/=10;
        }
        return ans%2==0;
    }

    public int countEven02(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10) {
            sum += i % 10;
        }
        return (num - (sum & 1)) / 2;
    }
}
