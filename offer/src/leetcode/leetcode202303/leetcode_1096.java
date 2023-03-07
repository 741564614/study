package leetcode.leetcode202303;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.*;

public class leetcode_1096 {

    public static void main(String[] args) {
//        System.out.println(new leetcode_1096().braceExpansionII("{id,{a,b,cd}}{d,f,g}"));
        String s = "dd{}{}";
        System.out.println(s.lastIndexOf("{", s.length() - 3));
        System.out.println(s.substring(0, 0));
    }

    TreeSet<String> ans = new TreeSet<>();

    public List<String> braceExpansionII02(String expression) {
        dfs(expression);
        return new ArrayList<>(ans);
    }

    public void dfs(String exp) {
        int j = exp.indexOf("}");
        if (j == -1) {
            ans.add(exp);
            return;
        }
        int i = exp.lastIndexOf("{", j);
        String a = exp.substring(0, i);
        String c = exp.substring(j + 1);
        for (String b : exp.substring(i + 1, j).split(",")) {
            dfs(a + b + c);
        }
    }

    class Solution {
        public List<String> braceExpansionII(String expression) {
            Deque<Character> op = new ArrayDeque<Character>();
            List<Set<String>> stk = new ArrayList<Set<String>>();

            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == ',') {
                    // 不断地弹出栈顶运算符，直到栈为空或者栈顶不为乘号
                    while (!op.isEmpty() && op.peek() == '*') {
                        ope(op, stk);
                    }
                    op.push('+');
                } else if (expression.charAt(i) == '{') {
                    // 首先判断是否需要添加乘号，再将 { 添加到运算符栈中
                    if (i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
                        op.push('*');
                    }
                    op.push('{');
                } else if (expression.charAt(i) == '}') {
                    // 不断地弹出栈顶运算符，直到栈顶为 {
                    while (!op.isEmpty() && op.peek() != '{') {
                        ope(op, stk);
                    }
                    op.pop();
                } else {
                    // 首先判断是否需要添加乘号，再将新构造的集合添加到集合栈中
                    if (i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
                        op.push('*');
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(expression.charAt(i));
                    stk.add(new TreeSet<String>() {{
                        add(sb.toString());
                    }});
                }
            }

            while (!op.isEmpty()) {
                ope(op, stk);
            }
            return new ArrayList<String>(stk.get(stk.size() - 1));
        }

        // 弹出栈顶运算符，并进行计算
        public void ope(Deque<Character> op, List<Set<String>> stk) {
            int l = stk.size() - 2, r = stk.size() - 1;
            if (op.peek() == '+') {
                stk.get(l).addAll(stk.get(r));
            } else {
                Set<String> tmp = new TreeSet<String>();
                for (String left : stk.get(l)) {
                    for (String right : stk.get(r)) {
                        tmp.add(left + right);
                    }
                }
                stk.set(l, tmp);
            }
            op.pop();
            stk.remove(stk.size() - 1);
        }
    }
}
