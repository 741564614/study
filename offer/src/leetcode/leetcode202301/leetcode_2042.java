package leetcode.leetcode202301;

public class leetcode_2042 {
    public boolean areNumbersAscending(String s) {
        int last = -1;
        for (String word : s.split(" ")) {
            if (!Character.isLowerCase(word.charAt(0))) {
                int i = Integer.parseInt(word);
                if (i <= last) {
                    return false;
                } else {
                    last = i;
                }
            }
        }
        return true;
    }
}
