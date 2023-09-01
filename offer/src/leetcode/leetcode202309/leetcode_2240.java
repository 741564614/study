package leetcode.leetcode202309;

public class leetcode_2240 {

    public static void main(String[] args) {
        System.out.println(new leetcode_2240().waysToBuyPensPencils(1000000,1,1));
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int k = total / cost1;
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans += (total - i * cost1) / (long)cost2 + 1;
        }
        return ans;
    }

    class Solution {
        public long waysToBuyPensPencils(int total, int cost1, int cost2) {
            int n=total/cost1,b=total%cost1;
            return euclid(cost1,b,cost2,n)+n+1;
        }
        public long euclid(int a,int b,int c,int n){
            if(n==0||a==0){return (long)b/c;}
            if(a>=c||b>=c){return (long)n*(n+1)/2*(a/c)+(long)(n+1)*(b/c)+euclid(a%c,b%c,c,n);}
            int m=(a*n+b)/c;
            return (long)n*m-euclid(c,c-b-1,a,m-1);
        }
    }
}
