package leetcode.leetcode202212;

public class leetcode_1780 {
    public boolean checkPowersOfThree02(int n) {
        while(n!=0){
            if(n%3==2){
                return false;
            }
            n/=3;
        }
        return true;
    }
}
