import java.util.Arrays;

/**
 * @Author @sushanbaskota
 * Reverse an array
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        reverseArray(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void reverseArray(int[] array) {
        int length = array.length;

        if (length >= 2) {
            for (int index = 0; index < length / 2; index++) { // need to go half way only
                int swapWithIndex = length - index - 1; // main task is to find the swap with index with present index

                int tempValue = array[index]; // this is just swapping using temp variable to hold value
                array[index] = array[swapWithIndex];
                array[swapWithIndex] = tempValue;
            }
        }
    }
}
