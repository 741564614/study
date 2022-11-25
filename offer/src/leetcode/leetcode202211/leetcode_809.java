package leetcode.leetcode202211;

public class leetcode_809 {
    public static void main(String[] args) {
        String s = "abccc";
        String[] words = new String[]{"abc"};

        System.out.println(new leetcode_809().expressiveWords(s, words));
    }

    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (check(s, word)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean check(String s, String word) {
        int j = 0;
        if (word.length() > s.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (j >= word.length()) {
                return false;
            }
            if (word.charAt(j) != s.charAt(i)) {
                return false;
            }
            int slen = count(s, i) - i + 1;
            int wlen = count(word, j) - j + 1;
            if (wlen > slen) {
                return false;
            } else {
                if (slen <= 2 && wlen != slen) {
                    return false;
                }
                i += slen - 1;
                j += wlen;
            }
        }

        return true;
    }

    public int count(String s, int index) {
        char a = s.charAt(index);
        while (index + 1 < s.length() && a == s.charAt(index + 1)) {
            index++;
        }
        return index;
    }


    public int expressiveWords02(String s, String[] words) {
        char[] cs = s.toCharArray();
        int ans = 0;
        for (String word : words) {
            if (check(cs, word)) {
                ans++;
            }
        }
        return ans;
    }

    boolean check(char[] s1, String s2) {
        int len1 = s1.length;
        int len2 = s2.length();
        if (len2 > len1) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        while (p2 < len2 && p1 < len1) {
            if (s2.charAt(p2) != s1[p1]) {
                return false;
            }
            int old1 = p1;
            int old2 = p2;
            char ch = s1[p1];
            //重复字符
            while (p1 < len1 && s1[p1] == ch) {
                p1++;
            }
            //相同字符
            while (p2 < len2 && s2.charAt(p2) == ch) {
                p2++;
            }
            //本题特殊处理-3
            int gap1 = p1 - old1;
            int gap2 = p2 - old2;
            if (gap1 < gap2 || (gap1 > gap2 && gap1 < 3)) {
                return false;
            }
        }
        return p1 == len1 && p2 == len2;
    }

}
