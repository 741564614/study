package leetcode.leetcode202209;

public class leetcode_854 {
    public static void main(String[] args) {

    }

    int ans;

    public int kSimilarity02(String s1, String s2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
            }
        }
        if(sb1.length()==0){
            return 0;
        }
        ans=sb1.length()-1;
        dfs(0, 0, sb1.length(), sb1.toString(), sb2.toString());
        return ans;
    }

    public void dfs(int pos, int cost, int len, String str1, String str2) {
        if (cost > ans) {
            return;
        }
        while (pos < str1.length() && str1.charAt(pos) == str2.charAt(pos)) {
            pos++;
        }
        if (pos == str1.length()) {
            ans = Math.min(ans, cost);
            return;
        }
        /* 当前状态的交换次数下限大于等于当前的最小交换次数 */
        if (cost + minSwap(str1, str2, pos) >= ans) {
            return;
        }
        for (int i = pos + 1; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(pos)) {
                String str1Next = swap(str1, i, pos);
                dfs(pos + 1, cost + 1, len, str1Next, str2);
            }
        }
    }

    public int minSwap(String s1, String s2, int pos) {
        int tot = 0;
        for (int i = pos; i < s1.length(); i++) {
            tot += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
        }
        return (tot + 1) / 2;
    }

    public String swap(String cur, int i, int j) {
        char[] arr = cur.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }
}
