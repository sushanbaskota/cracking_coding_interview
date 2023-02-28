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

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = targetSum - array[i];

            if (map.containsKey(complement)) {
                return new int[]{array[i], array[map.get(complement)]};
            } else {
                map.put(array[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum_bruteForce(new int[]{4, 6, 2, 7}, 9)));
        System.out.println(Arrays.toString(new TwoSum().twoSum_optimal(new int[]{4, 6, 2, 7}, 9)));
        System.out.println(Arrays.toString(new TwoSum().twoNumberSum(new int[]{4, 6, 2, 7}, 9)));
    }
}
