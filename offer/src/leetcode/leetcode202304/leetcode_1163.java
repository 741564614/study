package leetcode.leetcode202304;

public class leetcode_1163 {

    public static void main(String[] args) {
//        System.out.println(new leetcode_1163().lastSubstring("ababba"));
        System.out.println("ac".compareTo("ab"));
    }

    class Solution {
        public String lastSubstring(String s) {
            int i = 0, j = 1, n = s.length();
            while (j < n) {
                int k = 0;
                while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                    k++;
                }
                if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                    int t = i;
                    i = j;
                    j = Math.max(j + 1, t + k + 1);
                } else {
                    j = j + k + 1;
                }
            }
            return s.substring(i);
        }
    }


//    public String lastSubstring(String s) {
//        Trie root = new Trie();
//        for (int i = 0; i < s.length(); i++) {
//            root.add(s, i);
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        root.getLast(stringBuilder);
//        return stringBuilder.toString();
//    }
//
//    public class Trie {
//        Trie[] children;
//
//        public Trie() {
//            this.children = new Trie[26];
//        }
//
//        public void add(String s, int start) {
//            if (start >= s.length()) {
//                return;
//            }
//            char c = s.charAt(start);
//            if (children[c - 'a'] == null) {
//                children[c - 'a'] = new Trie();
//            }
//            children[c - 'a'].add(s, start + 1);
//        }
//
//        public void getLast(StringBuilder stringBuilder) {
//            for (int i = children.length - 1; i >= 0; i--) {
//                if (children[i] != null) {
//                    stringBuilder.append((char) (i + 'a'));
//                    children[i].getLast(stringBuilder);
//                    return;
//                }
//            }
//        }
//    }

//    public String lastSubstring(String s) {
//        char last = 'a';
//        for (char c : s.toCharArray()) {
//            if (c > last) {
//                last = c;
//            }
//        }
//        String ans = last + "";
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == last) {
//                String sub = s.substring(i);
//                if (sub.compareTo(ans) > 0) {
//                    ans = sub;
//                }
//            }
//        }
//        return ans;
//    }


}
