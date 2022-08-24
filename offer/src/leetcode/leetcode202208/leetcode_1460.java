package leetcode.leetcode202208;

public class leetcode_1460 {
    public static void main(String[] args) {

    }
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] check=new int[1010];
        for (int i : target) {
            check[i]++;
        }
        for (int i : arr) {
            check[i]--;
            if(check[i]<0){
                return false;
            }
        }
        return true;
    }
}
