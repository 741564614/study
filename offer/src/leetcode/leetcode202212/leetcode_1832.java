package leetcode.leetcode202212;

import java.util.HashSet;
import java.util.Set;

public class leetcode_1832 {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set=new HashSet<>();
        for (char c : sentence.toCharArray()) {
            set.add(c);
        }
        return set.size()==26;
    }
    public boolean checkIfPangram20(String sentence) {
        boolean[] check=new boolean[26];
        for (char c : sentence.toCharArray()) {
            check[c-'a']=true;
        }
        for (boolean b : check) {
            if(!b){
                return false;
            }
        }
        return true;
    }
}
