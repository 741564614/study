package leetcode.leetcode202208;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class leetcode_636 {
    public static void main(String[] args) {
        int n=2;
        String[] logs=new String[]{"0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"};
        System.out.println(exclusiveTime(n, Arrays.asList(logs)));
    }
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result=new int[n];
        Stack<String[]> stack=new Stack<>();
        Integer preTime=0;
        for (String log : logs) {
            String[] split = log.split(":");
            int end=Integer.parseInt(split[2]);
            if("start".equals(split[1])){
                if(!stack.isEmpty()){
                    String[] peek = stack.peek();
                    result[Integer.parseInt(peek[0])]+=(end-preTime);
                }
                stack.push(split);
            }else if("end".equals(split[1])){
                stack.pop();
                end++;
                result[Integer.parseInt(split[0])]+=(end-preTime);

            }
            preTime=end;
        }
        return result;
    }
}
