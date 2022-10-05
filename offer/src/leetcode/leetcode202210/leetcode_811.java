package leetcode.leetcode202210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_811 {
    public static void main(String[] args) {
        String[] key = new String[]{"9001 discuss.leetcode.com"};
        System.out.println(subdomainVisits(key));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Long> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            Long num = Long.valueOf(cpdomain.split(" ")[0]);
            String domain = cpdomain.split(" ")[1];
            while (domain.contains(".")) {
                map.put(domain, map.getOrDefault(domain, 0L) + num);
                domain = domain.substring(domain.indexOf(".") + 1);
            }
            map.put(domain, map.getOrDefault(domain, 0L) + num);
        }
        List<String> ans = new ArrayList<>();
        map.forEach((k, v) -> {
            ans.add(v.toString() + " " + k);
        });
        return ans;
    }

    public List<String> subdomainVisits02(String[] ss) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : ss) {
            int n = s.length(), idx = 0;
            while (idx < n && s.charAt(idx) != ' ') idx++;
            int cnt = Integer.parseInt(s.substring(0, idx));
            int start = idx + 1; idx = n - 1;
            while (idx >= start) {
                while (idx >= start && s.charAt(idx) != '.') idx--;
                String cur = s.substring(idx + 1);
                map.put(cur, map.getOrDefault(cur, 0) + cnt);
                idx--;
            }
        }
        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) ans.add(map.get(key) + " " + key);
        return ans;
    }
}
