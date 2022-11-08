package leetcode.leetcode202211;

public class leetcode_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] check=new boolean[26];
        for (char c : allowed.toCharArray()) {
            check[c-'a']=true;
        }
        int ans=0;

        for (String word : words) {
            boolean a=true;
            for (char c : word.toCharArray()) {
                if(!check[c-'a']){
                    a=false;
                    break;
                }
            }
            if(a){
                ans++;
            }
        }

        return ans;
    }

    public int countConsistentStrings02(String allowed, String[] words) {
        boolean[] hash = new boolean[26];
        for (char c : allowed.toCharArray()) hash[c - 'a'] = true;
        int ans = 0;
        out:for (String s : words) {
            for (char c : s.toCharArray()) {
                if (!hash[c - 'a']) continue out;
            }
            ans++;
        }
        return ans;
    }
}
