package leetcode.leetcode202212;

public class leetcode_1754 {
    public static void main(String[] args) {
        String a="cabaa";
        String b="bcaaa";
        System.out.println(new leetcode_1754().largestMerge(a,b));
    }
    public String largestMerge02(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }
        return merge.toString();
    }

    public String largestMerge(String word1, String word2) {
        int index1 = 0, index2 = 0;
        StringBuilder stringBuffer = new StringBuilder();
        while (index1 < word1.length() || index2 < word2.length()) {
            if (index1 < word1.length() && index2 < word2.length()) {
                if (word1.charAt(index1) > word2.charAt(index2)) {
                    stringBuffer.append(word1.charAt(index1++));
                } else if (word1.charAt(index1) < word2.charAt(index2)) {
                    stringBuffer.append(word2.charAt(index2++));
                } else {
                    int l = index1, r = index2;
                    while (l < word1.length() && r < word2.length() && word1.charAt(l) == word2.charAt(r)) {
                        l++;
                        r++;
                    }
                    if (l < word1.length() && r < word2.length()) {
                        if (word1.charAt(l) > word2.charAt(r)){
                            stringBuffer.append(word1.charAt(index1++));
                        }else{
                            stringBuffer.append(word2.charAt(index2++));
                        }
                    }else if(l < word1.length()){
                        stringBuffer.append(word1.charAt(index1++));
                    }else{
                        stringBuffer.append(word2.charAt(index2++));
                    }
                }
            } else if (index1 < word1.length()) {
                stringBuffer.append(word1.charAt(index1++));
            } else {
                stringBuffer.append(word2.charAt(index2++));
            }
        }
        return stringBuffer.toString();
    }
}
