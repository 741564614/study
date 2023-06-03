package leetcode.leetcode202306;

public class leetcode_1156 {

    public static void main(String[] args) {
        System.out.println(new leetcode_1156().maxRepOpt1("acbaaa"));
    }

    public int maxRepOpt1(String text) {
        int ans = 0;
        char[] array = text.toCharArray();
        int l = 0, n = text.length();
        while (l < n) {
            int r = l, next = l + 1;
            boolean isOne = false;
            while (r < n && array[l] == array[r]) {
                r++;
                if (r < n && !isOne && array[l] != array[r]) {
                    isOne = true;
                    next = r;
                    r++;
                }
            }
            boolean isReplace = false;
            for (int i = 0; i < l; i++) {
                if (array[i] == array[l]) {
                    isReplace = true;
                    break;
                }
            }
            for (int i = r; i < n; i++) {
                if (array[i] == array[l]) {
                    isReplace = true;
                    break;
                }
            }
            ans = Math.max(ans, isOne ? isReplace ? r - l : r - l - 1 : isReplace ? r - l + 1 : r - l);
            l = next;
        }
        return ans;
    }
}
