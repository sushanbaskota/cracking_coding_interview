package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/backtracking-to-find-all-subsets/">...</a>
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //List<List<Integer>> subsets = subsets(nums);
        List<List<Integer>> subsets = subsetIteration(nums);

        subsets.forEach(System.out::println);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        backtrack(subsets, tempList, nums, 0);

        return subsets;
    }

    private static void backtrack(List<List<Integer>> subsets, List<Integer> tempList, int[] nums, int start) {
        subsets.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // include current element
            tempList.add(nums[i]);

            // recursion until i is done
            backtrack(subsets, tempList, nums, i + 1);

            //remove from the list
            tempList.remove(tempList.size() - 1); //remove last
        }
    }

    /**
     * <a href="https://leetcode.com/problems/subsets-ii/solutions/388566/subsets-i-ii-java-solution-with-detailed-explanation-and-comments-recursion-iteration/">...</a>
     */

    private static List<List<Integer>> subsetIteration(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        resultList.add(new ArrayList<>()); // start with empty

        for (int i = 0; i < nums.length; i++) { // go through each input elements
            List<List<Integer>> newResult = new ArrayList<>();

            for (List<Integer> result : resultList) { // for each input element num, loop over the current resultList list constructed so far
                List<Integer> cloneResult = new ArrayList<>(result); // copy is required to not change the original result list

                cloneResult.add(nums[i]); // same like backtracking , pick the element

                newResult.add(cloneResult);
            }

            resultList.addAll(newResult);
        }

        return resultList;
    }
}
