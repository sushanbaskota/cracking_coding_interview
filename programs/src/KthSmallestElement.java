import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // max heap, default is min heap

        for (int num : nums) {
            priorityQueue.add(num);
        }

        int largest = 1;

        for (int i = 0; i < k; i++) {
            largest = priorityQueue.remove();
        }

        return largest;
    }
}
