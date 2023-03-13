package offer;

public class offer_53_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 7, 7, 7, 8, 8, 10};
        System.out.println(new offer_53_1().search(nums, 7));
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, indexL = 0;
        if (r < l) {
            return 0;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        indexL = Math.min(nums.length - 1, l);
        if (nums[indexL] != target) {
            return 0;
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l - indexL;
    }
}
