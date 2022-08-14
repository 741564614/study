public class leetcode_1422 {
    public static void main(String[] args) {
        String s="011100";
        System.out.println(maxScore(s));
    }
    public static int maxScore(String s) {
        int max=0;
        int right=0;
        int left=0;
        for(char a:s.toCharArray()){
            if(a=='1'){
                right++;
            }
        }
        for (int i = 0; i < s.length()-1; i++) {
            char a= s.charAt(i);
            if(a=='0'){
                left++;
            }else{
                right--;
            }
            max=Math.max(left+right,max);
        }
        return max;
    }

    public static int maxScore2(String s) {
        int n = s.length(), ans = 0;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + (s.charAt(i - 1) - '0');
        for (int i = 1; i <= n - 1; i++) {
            int a = i - sum[i], b = sum[n] - sum[i];
            ans = Math.max(ans, a + b);
        }
        return ans;
    }
}
