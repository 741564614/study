package offer;

public class offer_58 {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].length() > 0) {
                sb.append(split[i]);
                sb.append(" ");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
