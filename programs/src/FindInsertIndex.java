public class FindInsertIndex {
    public static void main(String[] args) {
        int[] nums = {1, 8, 18, 27, 35, 56, 78, 98, 100};
        int target = 56;

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            int numMiddle = nums[middle];

            if (numMiddle == target) {
                return middle;
            } else if (numMiddle < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
}
