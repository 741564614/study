package leetcode.leetcode202301;

public class leetcode_2299 {
    public boolean strongPasswordCheckerII(String password) {
        boolean[] ans=new boolean[4];
        if(password.length()<8){
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            char c=password.charAt(i);
            if(Character.isLowerCase(c)){
                ans[0]=true;
            }
            if(Character.isUpperCase(c)){
                ans[1]=true;
            }
            if(c-'0'>=0&&c-'0'<=9){
                ans[2]=true;
            }
            if("!@#$%^&*()-+".contains(String.valueOf(c))){
                ans[3]=true;
            }
            if(i>0&&c==password.charAt(i-1)){
                return false;
            }
        }
        for (boolean an : ans) {
            if(!an){
                return false;
            }
        }
        return true;
    }
}
