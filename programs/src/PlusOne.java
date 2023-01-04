import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1; //start from last element

        while (i >= 0) {
            if (digits[i] == 9) { // corner case 1: if elem == 9, change to 0
                digits[i] = 0;
                i--;
            } else { // if the current itself is not 9, just add 1 and return, no need to carry
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        // if it reaches here, there is still and carry for eg: [9,9,9] scenario,
        // i.e all input elements were 9
        // corner case 2: if all inputs were all 9
        int[] newArr = new int[digits.length + 1]; // we need MSB to 1 and other 0
        newArr[0] = 1; // change MSB to 1 other are default to 0

        return newArr;
    }

    public int[] plusOne1(int[] digits) {
        // Start from the last element in the array and move backwards
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the current element is less than 9, we can simply add 1 and return the modified array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If the current element is 9, we set it to 0 and continue the loop
            digits[i] = 0;
        }

        // If we reach this point, it means the input array represents the maximum value of an integer
        // (e.g. [9, 9, 9, 9]). In this case, we need to create a new array with an additional element
        // at the beginning and set it to 1.
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        //int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        //int[] digits = {9};
        // int[] digits = {4, 3, 2, 1};
        int[] digits = {9, 9, 1};
        int[] result = new PlusOne().plusOne(digits);
        //int[] result = new PlusOne().plusOne(digits);

        Arrays.stream(result).forEach(System.out::println);
    }
}
