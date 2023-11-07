package app;

import java.util.HashMap;
import java.util.Map;

public class FindComplement {
    // time complexity is O(n^2)
    // space complexity is 0(1)
    public int[] twoSumOld(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no two sum solutions");
    }

    // hashmaps have constants look-up times
    // time complexity is O(n)
    // space complexity is 0(1)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solutions");
    }
}
