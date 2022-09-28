package leetcode.leetcode202209;

import java.util.*;

public class Interview_questions_17_09 {
    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(8));
    }

    public static int getKthMagicNumber(int k) {
        int[] factor = new int[]{3, 5, 7};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        List<Long> list = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        queue.offer(1L);
        set.add(1L);
        while (!queue.isEmpty()) {
            Long poll = queue.poll();
            if (--k == 0) return poll.intValue();
            for (int f : factor) {
                if (!set.contains(f * poll)) {
                    queue.offer(f * poll);
                    set.add(f * poll);
                }
            }
        }
        return -1;
    }

    public int getKthMagicNumber02(int k) {
        int[] arr=new int[k];
        arr[0]=1;
        int p3=0;
        int p5=0;
        int p7=0;

        for(int i=1;i<k;i++){
            int min=Math.min(3*arr[p3],5*arr[p5]);
            min=Math.min(min,7*arr[p7]);

            if(min==3*arr[p3]){
                p3++;
            }
            if(min==5*arr[p5]){
                p5++;
            }
            if(min==7*arr[p7]){
                p7++;
            }

            arr[i]=min;
        }

        return arr[k-1];
    }
}
