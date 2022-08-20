package leetcode.leetcode202208;

import java.util.*;

public class leetcode_768 {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,2,1,1,3,4,5,1,6};
        System.out.println(maxChunksToSorted3(a));
    }

    public static int maxChunksToSorted(int[] arr) {
        int[] value = Arrays.copyOf(arr, arr.length);
        Arrays.sort(value);
        Map<Integer, Queue<Integer>> keyMap = new HashMap<>();
        for (int i = 0; i < value.length; i++) {
            Queue<Integer> orDefault = keyMap.getOrDefault(value[i], new LinkedList<>());
            orDefault.offer(i);
            keyMap.put(value[i], orDefault);
        }
        boolean[] have = new boolean[arr.length];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                Queue<Integer> queue = keyMap.get(arr[j]);
                Integer poll = queue.poll();
                have[poll] = true;
                if(check(have,i,j)){
                    ans++;
                    i=j;
                    break;
                }
            }
        }
        return ans;
    }

    public static boolean check(boolean[] have, int start, int end) {
        boolean result = true;
        for (int j = start; j <= end; j++) {
            result = result && have[j];
        }
        return result;
    }

    public static int maxChunksToSorted3(int[] arr){
        Stack<Integer> stack=new Stack<>();
        for (int i : arr) {
            if(!stack.isEmpty()&&i<stack.peek()){
                Integer pop = stack.pop();
                while(!stack.isEmpty()&&i<stack.peek()){
                    stack.pop();
                }
                stack.push(pop);
            }else{
                stack.push(i);
            }
        }
        return stack.size();
    }

    public static int maxChunksToSorted2(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int res = 0;
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        for (int i = 0; i < sortedArr.length; i++) {
            int x = arr[i], y = sortedArr[i];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 0) {
                cnt.remove(x);
            }
            cnt.put(y, cnt.getOrDefault(y, 0) - 1);
            if (cnt.get(y) == 0) {
                cnt.remove(y);
            }
            if (cnt.isEmpty()) {
                res++;
            }
        }
        return res;
    }

}
