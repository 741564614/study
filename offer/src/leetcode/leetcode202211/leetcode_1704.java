package leetcode.leetcode202211;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_1704 {
    List<Character> list= Arrays.asList('a','e','i','o','u','A','E','I','O','U');
    public boolean halvesAreAlike(String s) {
        int half=s.length()/2;
        int ans=0;
        for (int i = 0; i < half; i++) {
            if(list.contains(s.charAt(i))){
                ans++;
            }
            if(list.contains(s.charAt(half+i))){
                ans--;
            }
        }
        return ans==0;
    }

    public boolean halvesAreAlike20(String s) {
        int half=s.length()/2;
        int ans=0;
        for (int i = 0; i < half; i++) {
            int p = "aeiouAEIOU".indexOf(s.charAt(i));
            if(p!=-1){
                ans++;
            }
            int q = "aeiouAEIOU".indexOf(s.charAt(half+i));
            if(q!=-1){
                ans--;
            }
        }
        return ans==0;
    }
}
