package leetcode.leetcode202209;

public class leetcode_672 {
    public static void main(String[] args) {

    }
    public int flipLights02(int n, int k) {
        if (k == 0) return 1;
        if (n == 1) return 2;
        else if (n == 2) return k == 1 ? 3 : 4;
        else return k == 1 ? 4 : k == 2 ? 7 : 8;
    }
}
