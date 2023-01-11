import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum_bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public int[] twoSum_optimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        /**
         * 4 0
         * 6 1
         * 2 2
         *
         */

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum_bruteForce(new int[]{4, 6, 2, 7}, 9)));
        System.out.println(Arrays.toString(new TwoSum().twoSum_optimal(new int[]{4, 6, 2, 7}, 9)));
    }
}
