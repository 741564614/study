package leetcode.leetcode202208;

public class leetcode_1455 {
    public static void main(String[] args) {

    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() >= searchWord.length() && split[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
