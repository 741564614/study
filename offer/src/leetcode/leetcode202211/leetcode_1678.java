package leetcode.leetcode202211;

public class leetcode_1678 {
    public String interpret(String command) {
        return command.replace("()","o").replace("(al)","al");
    }
}
