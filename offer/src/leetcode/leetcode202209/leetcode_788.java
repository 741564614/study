package leetcode.leetcode202209;

public class leetcode_788 {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(857));
    }

    public int rotatedDigits02(int n) {
        int ans = 0;
        out:for (int i = 1; i <= n; i++) {
            boolean ok = false;
            int x = i;
            while (x != 0) {
                int t = x % 10;
                x /= 10;
                if (t == 2 || t == 5 || t == 6 || t == 9) ok = true;
                else if (t != 0 && t != 1 && t != 8) continue out;
            }
            if (ok) ans++;
        }
        return ans;
    }
    public static int rotatedDigits(int n) {
        int[] note=new int[n+1];
        for(int i=1;i<=n;i++){
            note[i]=note[i-1]+valid(i);
        }
        return note[n];
    }
    public static int valid(int k){
        int ans=0;
        int p=k;
        while(k>0){
            int t=k%10;
            if(t==3||t==4||t==7){
                return 0;
            }
            if(t==2||t==5||t==6||t==9){
                ans=1;
            }
            k/=10;
        }
        return ans;
    }
}
