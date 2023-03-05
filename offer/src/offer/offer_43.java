package offer;

public class offer_43 {
    public int countDigitOne02(int n) {
        int high = n / 10, low = 0, cur = n % 10, digit = 1;
        int ans = 0;
        while (high != 0 || cur != 0) {
            switch (cur) {
                case 0:
                    ans += high * digit;
                    break;
                case 1:
                    ans += high * digit + low + 1;
                    break;
                default:
                    ans += (high + 1) * digit;
                    break;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return ans;
    }
}
