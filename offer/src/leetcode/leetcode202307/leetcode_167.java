package leetcode.leetcode202307;

public class leetcode_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int next = binarySearch(numbers, i + 1, target - numbers[i]);
            if (next != -1) {
                ans[0] = i + 1;
                ans[1] = next + 1;
                break;
            }
        }
        return ans;
    }

    public int binarySearch(int[] nums, int left, int target) {
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public int[] twoSum02(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int value = numbers[left] + numbers[right];
            if (value == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (value > target) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
}
