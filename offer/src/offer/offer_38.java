package offer;

import java.util.HashSet;
import java.util.Set;

public class offer_38 {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] check=new boolean[chars.length];
        Set<String> set=new HashSet<>();
        dfs(chars,check,set,new StringBuffer(),s.length());
        String[] ans=new String[set.size()];
        int i=0;
        for (String s1 : set) {
            ans[i++]=s1;
        }
        return ans;
    }

    public void dfs(char[] chars,boolean[] check, Set<String> set,StringBuffer stringBuffer,int target){
        if(stringBuffer.length()==target){
            set.add(stringBuffer.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if(!check[i]){
                check[i]=true;
                stringBuffer.append(chars[i]);
                dfs(chars,check,set,stringBuffer,target);
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
                check[i]=false;
            }
        }
    }
}
