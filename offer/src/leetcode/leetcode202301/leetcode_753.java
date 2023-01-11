package leetcode.leetcode202301;

import java.util.HashMap;
import java.util.Map;

public class leetcode_753 {
    public static String crackSafe02(int n,int k){
        Map<String,Integer> map = new HashMap<>();
        int kn = (int) Math.pow(k,n);//路径数量
        StringBuffer ans = new StringBuffer();
        //初始结点为000...
        for(int i = 1;i < n;i++){
            ans.append('0');
        }
        if(ans.length() == 0){
            for(int i = 0;i < k; i++){
                ans.append(i);
            }
            return ans.toString();
        }
        //遍历所有的路
        while (kn != 0){
            String substring = ans.substring(ans.length() - n + 1, ans.length());
            if(!map.containsKey(substring))
                map.put(substring,k-1);
            ans.append(map.get(substring));
            map.put(substring,map.get(substring) - 1);
            kn--;
        }
        return ans.toString();
    }
}
