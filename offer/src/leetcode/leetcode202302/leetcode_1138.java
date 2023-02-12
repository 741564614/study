package leetcode.leetcode202302;

public class leetcode_1138 {
    public static void main(String[] args) {
        System.out.println(new leetcode_1138().alphabetBoardPath("zdz"));
    }

    public String alphabetBoardPath(String target) {
        int i = 0, j = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : target.toCharArray()) {
            int nextI = (c - 'a') / 5, nextJ = (c - 'a') % 5;
            while (i != nextI || j != nextJ) {
                while (i - nextI > 0) {
                    stringBuffer.append("U");
                    i--;
                }
                while (nextI - i > 0 && (i + 1 < 5 || j == 0)) {
                    stringBuffer.append("D");
                    i++;
                }
                while (j - nextJ > 0) {
                    stringBuffer.append("L");
                    j--;
                }
                while (nextJ - j > 0 && i != 5) {
                    stringBuffer.append("R");
                    j++;
                }
            }
            stringBuffer.append("!");
        }
        return stringBuffer.toString();
    }

    public String alphabetBoardPath20(String target) {
        int i = 0, j = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : target.toCharArray()) {
            int nextI = (c - 'a') / 5, nextJ = (c - 'a') % 5;
            if (i != nextI || j != nextJ) {
                while (i - nextI > 0) {
                    stringBuffer.append("U");
                    i--;
                }
                while (j - nextJ > 0) {
                    stringBuffer.append("L");
                    j--;
                }
                while (nextI - i > 0) {
                    stringBuffer.append("D");
                    i++;
                }
                while (nextJ - j > 0) {
                    stringBuffer.append("R");
                    j++;
                }
            }
            stringBuffer.append("!");
        }
        return stringBuffer.toString();
    }

}
