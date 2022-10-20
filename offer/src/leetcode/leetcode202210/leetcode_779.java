package leetcode.leetcode202210;

public class leetcode_779 {
    public static void main(String[] args) {
        kthGrammar(3, 2);
    }

    public static int kthGrammar(int n, int k) {
        boolean change = false;
        while (k > 1) {
            if (k % 2 != 0) {
                k++;
            } else {
                change = !change;
            }
            k /= 2;
        }
        return change ? 1 : 0;
    }

    public int kthGrammar02(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }

}
