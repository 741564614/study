package offer;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.*;

public class offer_50 {
    public char firstUniqChar20(String s) {
        Map<Character, Integer> map = new HashMap<>();
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
                list.offer(c);
            } else {
                map.put(c, -1);
                while (!list.isEmpty() && map.get(list.peek()) == -1) {
                    list.poll();
                }
            }
        }
        return list.isEmpty() ? ' ' : list.poll();
    }

    public char firstUniqChar03(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

    public char firstUniqChar04(String s) {
        //判断字母a-z是否在s中只出现了一次，在判断哪一个是最先的
        int ans=50001;//s长度小于5000
        int first,last;
        for(int i=0;i<26;i++){
            char ch=(char)('a'+i);
            first=s.indexOf(ch);
            if(first!=-1){
                //说明s中包含有该字母
                last=s.lastIndexOf(ch);
                if(first==last){
                    //说明该字母只出现了一次，记录出现位置
                    ans=ans>first?first:ans;
                }
            }
        }
        return ans==50001?' ':s.charAt(ans);
    }


    public char firstUniqChar(String s) {
        char ans = ' ';
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1) {
                return c;
            }
        }
        return ans;
    }
}
