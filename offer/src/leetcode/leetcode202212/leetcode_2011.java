package leetcode.leetcode202212;

public class leetcode_2011 {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for (String operation : operations) {
            if(operation.charAt(0)=='+'||operation.charAt(operation.length()-1)=='+'){
                ans++;
            }else{
                ans--;
            }
        }
        return ans;
    }
}
