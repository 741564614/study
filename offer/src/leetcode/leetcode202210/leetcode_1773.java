package leetcode.leetcode202210;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class leetcode_1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int type=0;
        if(ruleKey.equals("color")){
            type=1;
        }
        else if(ruleKey.equals("name")){
            type=2;
        }
        int ans=0;
        for (List<String> item : items) {
            if(item.get(type).equals(ruleValue)){
                ans++;
            }
        }
        return ans;
    }
}
