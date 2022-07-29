import java.util.*;

public class leetcode_593 {
    public static void main(String[] args) {
        int[] p1 = {0,0}, p2 = {0,0}, p3 = {5,4}, p4 = {0,4};
        System.out.println(validSquare(p1,p2,p3,p4));
    }
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Double> priorityQueue=new HashSet<>();
        if(Arrays.equals(p1,p2)||Arrays.equals(p1,p3)||Arrays.equals(p1,p4)||Arrays.equals(p3,p2)||Arrays.equals(p4,p2)||Arrays.equals(p3,p4)){
            return false;
        }
        priorityQueue.add(lengthCount(p1,p2));
        priorityQueue.add(lengthCount(p1,p3));
        priorityQueue.add(lengthCount(p1,p4));
        priorityQueue.add(lengthCount(p2,p3));
        priorityQueue.add(lengthCount(p2,p4));
        priorityQueue.add(lengthCount(p3,p4));
        return priorityQueue.size()==2;
    }

    public static double lengthCount(int[] a,int[] b){
        return Math.pow(Math.abs(a[0]-b[0]),2)+Math.pow(Math.abs(a[1]-b[1]),2);
    }
}
