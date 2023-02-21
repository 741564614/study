package offer;

import java.util.Stack;

public class offer_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int push : pushed) {
            stack.push(push);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }

    public boolean validateStackSequences02(int[] pushed, int[] popped) {
        int i = 0,j = 0;
        for(int num : pushed) {
            pushed[i] = num;
            while(i >= 0 && pushed[i] == popped[j]) {
                i--;
                j++;
            }
            i++;
        }
        return i == 0;
    }
}
