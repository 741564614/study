package offer;

public class offer_46 {
    public static void main(String[] args) {
        System.out.println(new offer_46().translateNum(1112912));
    }
    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int ans = 1, prev = 1;
        for (int i = 1; i < chars.length; i++) {
            int temp = ans;
            if (chars[i - 1] - '0' == 1 || (chars[i - 1] - '0' == 2 && chars[i] - '0' <= 5)) {
                ans += prev;
            }
            prev = temp;
        }
        return ans;
    }
}
