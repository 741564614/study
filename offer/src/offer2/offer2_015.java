package offer2;

import java.util.ArrayList;
import java.util.List;

public class offer2_015{
    public static void main(String[] args) {
        String s="cbaebabacd" ,p="abc";
        findAnagrams(s,p);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] needs=new int[128];
        List<Integer> result=new ArrayList<>();
        int l=0,r=0,count=0;
        if(null==s||null==p||s.length()==0||p.length()==0){
            return result;
        }
        for(char a:p.toCharArray()) needs[a]++;
        while(r<s.length()){
            char a=s.charAt(r++);
            if(needs[a]>0){
                count++;
                if(count==p.length()){
                    result.add(l);
                }
            }
            needs[a]--;
            while(r-l>=p.length()){
                needs[s.charAt(l)]++;
                if(needs[s.charAt(l++)]>0){
                    count--;
                }
            }
        }
        return result;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        int[] memo = new int[26];
        for(char c : cp) memo[c-'a']++;

        int left = 0, right = 0;
        int[] visited = new int[26];

        while(right < cs.length){
            int idx = cs[right++] - 'a';
            visited[idx]++;
            while(visited[idx] > memo[idx]) visited[cs[left++] - 'a']--;

            if(right - left == p.length()) ans.add(left);
        }
        return ans;
    }
}