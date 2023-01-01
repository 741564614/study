package leetcode.leetcode202301;

public class leetcode_2351 {
    public char repeatedCharacter(String s) {
        int[] check=new int[26];
        for (char c : s.toCharArray()) {
            check[c-'a']++;
            if(check[c-'a']>=2){
                return c;
            }
        }
        return s.charAt(0);
    }
}
