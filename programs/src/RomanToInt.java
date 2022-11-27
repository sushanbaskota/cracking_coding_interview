import java.util.HashMap;
import java.util.Stack;

public class RomanToInt {
    public int romanToInt(String s) {
        int sum = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char letter = s.charAt(i);
            int currentLetterValue = getValue(letter);
            if (length > i + 1) {
                int rightLetterValue = getValue(s.charAt(i + 1));
                if (currentLetterValue >= rightLetterValue) {
                    sum = sum + currentLetterValue;
                } else {
                    sum = sum - currentLetterValue;
                }
            } else {
                sum = sum + currentLetterValue;
            }
        }

        return sum;
    }

    public int romanToIntStack(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        char[] arr = s.toCharArray();

        Stack<Character> st = new Stack<>();

        for (char i : arr) {
            st.push(i);
        }

        int prevValue = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char popChar = st.pop();
            int currentValue = map.get(popChar);
            if (currentValue >= prevValue)
                sum += currentValue;
            else
                sum -= currentValue;

            prevValue = currentValue;

        }
        return sum;
    }

    private int getValue(char letter) {
        if (letter == 'I') {
            return 1;
        } else if (letter == 'V') {
            return 5;
        } else if (letter == 'X') {
            return 10;
        } else if (letter == 'L') {
            return 50;
        } else if (letter == 'C') {
            return 100;
        } else if (letter == 'D') {
            return 500;
        } else if (letter == 'M') {
            return 1000;
        }

        return -1;
    }

    public static void main(String[] args) {
        //System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
        System.out.println(new RomanToInt().romanToIntStack("MCMXCIV"));
    }
}
