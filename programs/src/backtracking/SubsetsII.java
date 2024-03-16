package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/backtracking-to-find-all-subsets/">...</a>
 */
public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        List<List<Integer>> subsets = subsets(nums);

        subsets.forEach(System.out::println);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);  // sorting is required, as we want to compare current and previous element if they are same

        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        backtrack(subset, tempList, nums, 0);

        return subset;
    }

    private static void backtrack(List<List<Integer>> subset, List<Integer> tempList, int[] nums, int start) {
        subset.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { // if the element is same skip
                continue;
            }
            // include current element
            tempList.add(nums[i]);

            // recursion until i is done
            backtrack(subset, tempList, nums, i + 1);

            //remove from the list
            tempList.remove(tempList.size() - 1); //remove last
        }
    }
}
