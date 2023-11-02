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

    public int[] twoNumberSum(int[] array, int targetSum) {
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


    public int[] twoNumberSum_TwoPointers(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int arrSum = array[left] + array[right];

            if (arrSum == targetSum) { // 2 4 6 7 , 8
                return new int[]{array[left], array[right]};
            } else if (arrSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        //System.out.println(Arrays.toString(new TwoSum().twoSum_bruteForce(new int[]{4, 6, 2, 7}, 9)));
        //System.out.println(Arrays.toString(new TwoSum().twoSum_optimal(new int[]{4, 6, 2, 7}, 9)));
        //System.out.println(Arrays.toString(new TwoSum().twoNumberSum(new int[]{4, 6, 2, 7}, 9)));
        //  System.out.println(Arrays.toString(new TwoSum().
        //        twoNumberSum_TwoPointers(new int[]{4, 6, 2, 7}, 13)));
    }
}
