package leetcode.leetcode202210;

public class leetcode_1768 {
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0, index2 = 0;
        StringBuffer sb = new StringBuffer();
        while (index1 < word1.length() && index2 < word2.length()) {
            sb.append(word1.charAt(index1++));
            sb.append(word2.charAt(index2++));
        }
        while (index1 < word1.length()) {
            sb.append(word1.charAt(index1++));
        }
        while (index2 < word2.length()) {
            sb.append(word2.charAt(index2++));
        }
        return sb.toString();
    }

    public String mergeAlternately02(String word1,String word2){
        int len1 = word1.length(), len2 = word2.length(), idx = 0;
        char[] res = new char[len1 + len2];
        for(int i = 0; i < len1 || i < len2; ++i) {
            if(i < len1) res[idx++] = word1.charAt(i);
            if(i < len2) res[idx++] = word2.charAt(i);
        }
        return new String(res);
    }
}
