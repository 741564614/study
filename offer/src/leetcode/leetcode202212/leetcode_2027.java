package leetcode.leetcode202212;

public class leetcode_2027 {
    public int minimumMoves(String s) {
        int ans=0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='X'){
                int cnt=0;
                while(i<chars.length&&cnt<2){
                    cnt++;
                    i++;
                }
                ans++;
            }
        }

        return ans;
    }

    public int minimumMoves02(String s) {
        int ans=0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='X'){
                i+=2;
                ans++;
            }
        }

        return ans;
    }
}
