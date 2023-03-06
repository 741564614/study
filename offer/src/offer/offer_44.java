package offer;

public class offer_44 {
    public static void main(String[] args) {
        System.out.println(new offer_44().findNthDigit(30));
    }


    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        n -= 10;
        long digit = 10, num = 2;
        while (n > digit * 9 * num) {
            n -= (digit * 9 * num);
            digit *= 10;
            num++;
        }

        StringBuilder sb = new StringBuilder();
        int isFirst = 1;
        while (digit > 0) {
            int max = isFirst;
            while (n >= digit * (max + 1 - isFirst) * num) {
                max++;
            }
            n -= digit * (max - isFirst) * num;
            sb.append(max);
            isFirst = 0;
            digit /= 10;
        }
        return sb.toString().charAt(n) - '0';
    }

    public int findNthDigit02(int n) {
        int len = 1;
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= len * 9 * Math.pow(10, len - 1);
            len++;
        }
        long s = (long) Math.pow(10, len - 1);
        long x = n / len - 1 + s;
        n -= (x - s + 1) * len;
        return n == 0 ? (int) (x % 10) : (int) ((x + 1) / Math.pow(10, len - n) % 10);
    }
}
