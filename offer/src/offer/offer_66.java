package offer;

public class offer_66 {
    public int[] constructArr(int[] a) {
        int prefix = 1;
        int[] suffix = new int[a.length];
        int[] ans = new int[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            if (i == a.length - 1) {
                suffix[i] = 1;
            } else {
                suffix[i] = suffix[i + 1] * a[i + 1];
            }
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = prefix * suffix[i];
            prefix *= a[i];
        }
        return ans;
    }
}
