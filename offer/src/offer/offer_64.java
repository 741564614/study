package offer;

public class offer_64 {
    public int sumNums02(int n) {
        boolean flag = n > 0 && (n += sumNums02(n - 1)) > 0;
        return n;
    }
}
