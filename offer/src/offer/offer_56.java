package offer;

public class offer_56 {
    public int[] singleNumbers(int[] nums) {
        int x = 0, a = 0, b = 0;
        for (int num : nums) {
            x ^= num;
        }
        int offerSet = 32 - Integer.numberOfLeadingZeros(x) - 1;
        int temp = 1 << offerSet;
        for (int num : nums) {
            if ((num & temp) > 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
    public int[] singleNumbers02(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
