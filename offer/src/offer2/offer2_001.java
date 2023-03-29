package offer2;

public class offer2_001 {
    public int divide02(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isPositive = true;
        if (a > 0) {
            isPositive = false;
            a = -a;
        }
        if (b > 0) {
            isPositive = !isPositive;
            b = -b;
        }
        int ans = div(a, b);
        return isPositive ? ans : -ans;
    }

    public int div(int a, int b) {
        int ans = 0;
        while (a <= b) {
            int count = 1;
            int temp = b;
            while (temp >= 0xc0000000 && a <= temp + temp) {
                count += count;
                temp += temp;
            }
            ans += count;
            a -= temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new offer2_001().div(Integer.MIN_VALUE,-1));
        System.out.println(0xc0000000);
    }

}
