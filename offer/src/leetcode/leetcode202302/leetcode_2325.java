package leetcode.leetcode202302;

public class leetcode_2325 {
    public String decodeMessage(String key, String message) {
        int[] indexs = new int[26];

        int index = 1;

        for (char c : key.toCharArray()) {
            if (c != ' ' && indexs[c - 'a'] == 0) {
                indexs[c - 'a'] = index++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (char a : message.toCharArray()) {
            if (a == ' ') {
                sb.append(a);
            } else {
                sb.append((char) (indexs[a - 'a'] + 'a' - 1));
            }
        }
        return sb.toString();
    }
}
