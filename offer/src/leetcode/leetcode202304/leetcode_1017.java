package leetcode.leetcode202304;

public class leetcode_1017 {
    public static void main(String[] args) {
        System.out.println(new leetcode_1017().baseNeg2(6));
        int a = -3, b = -2;
        //设a%b=x，a/b=y，则有x+by=a，b固定为-2，转换成x-2y=a，又因为a是常量，设x1为变更后的x，y1为变更后的y，变更后保持a不变，
        // 则有x-2y=x1-2y1，因为要让x从-1变成1，则有x1=x+2，代入可得y1=y+1，所以要将-1的余数转换成1用于负二进制中，需将商加1
        System.out.println(a % b);
        System.out.println(a / b);
    }

    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int base = -2;
        while (n != 0) {
            int cos = n % base;
            if (cos < 0) {
                cos = -cos;
                n = n / base + 1;
            } else {
                n /= base;
            }
            stringBuilder.append(cos);

        }
        return stringBuilder.reverse().toString();
    }
}
