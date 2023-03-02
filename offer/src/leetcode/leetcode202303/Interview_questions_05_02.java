package leetcode.leetcode202303;

public class Interview_questions_05_02 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (num != 0) {
            if (sb.length() >= 32) {
                return "ERROR";
            }
            num *= 2;
            int x = (int) num;
            sb.append(x);
            num -= x;
        }
        return sb.toString();
    }
}
