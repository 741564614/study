package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class offer_39 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) >= max) {
                ans = num;
                max = map.get(num);
            }
        }
        return ans;
    }

    public int majorityElement20(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
