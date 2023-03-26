package offer;

public class offer_65 {
    public int add(int a, int b) {
        if (b == 0) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        int sum = 0;
        while (b != 0) {
            sum = a ^ b;
            b = ((a & b) << 1);
            a = sum;
        }
        return sum;
    }

    public int add02(int a, int b) {
        if(b==0) return a;
        return add02(a^b,(a&b)<<1);
    }
}
