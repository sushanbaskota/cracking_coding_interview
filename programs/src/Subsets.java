import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/backtracking-to-find-all-subsets/">...</a>
 */
public class Subsets {

    public static void calcSubset(
            List<Integer> nums,
            List<List<Integer>> subsets,
            List<Integer> tempList,
            int index
    ) {
        // Add the current subset to the result list
        subsets.add(new ArrayList<>(tempList));

        // Generate subsets by recursively including and
        // excluding elements
        for (int i = index; i < nums.size(); i++) {
            // Include the current element in the subset
            tempList.add(nums.get(i));

            // Recursively generate subsets with the current
            // element included
            calcSubset(nums, subsets, tempList, i + 1);

            // Exclude the current element from the subset
            // (backtracking)
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(List<Integer> nums) {
        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();

        int index = 0;

        calcSubset(nums, subsets, tempList, index);

        return subsets;
    }

    // Driver code

    public static void main(String[] args) {
        List<Integer> array = List.of(1, 2, 3);
        List<List<Integer>> res = subsets(array);

        // Print the generated subsets
        res.forEach(System.out::println);
    }
}
