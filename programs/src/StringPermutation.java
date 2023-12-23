import java.util.Stack;

public class StringPermutation {

    public static void main(String[] args) {
//        String word = "abcd";
//
//        int index = 1;
//
//        String newWord = word.substring(0, index) + word.substring(index + 1);
//
//        System.out.println(newWord);
        listPermutation("abc");
    }

    private static void listPermutation(String word) {
        //recursivePermutation("", word);
        iterativePermutation(word);
    }

    private static void recursivePermutation(String soFar, String rest) {
        if (rest.equalsIgnoreCase("")) {
            System.out.println(soFar);
        } else {
            for (int i = 0; i < rest.length(); i++) {
                String next = soFar + rest.charAt(i); // take a letter to append // 1 char more than soFar
                String remaining = rest.substring(0, i) + rest.substring(i + 1); // remove the above letter from string,
                // to make sure same letter is not used // bc

                recursivePermutation(next, remaining); // a, bc
            }
        }
    }

    private static void iterativePermutation(String input) {
        int counter = 0;
        Stack<String> soFarStack = new Stack<>();
        soFarStack.push("");

        Stack<String> restStack = new Stack<>();
        restStack.push(input);

        while (!soFarStack.isEmpty()) {
            String soFar = soFarStack.pop();
            String rest = restStack.pop();

            if (rest.equalsIgnoreCase("")) {
                System.out.println(soFar);
            } else {
                for (int i = 0; i < rest.length(); i++) {
                    String next = soFar + rest.charAt(i);
                    String remaining = rest.substring(0, i) + rest.substring(i + 1);

                    soFarStack.push(next);
                    restStack.push(remaining);
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}

//    public List<List<Integer>> permute(int[] nums) {
//        permuteList();
//    }
//
//    private static List<List<Integer>> permuteList(int[] soFar, int[] rest, List<List<Integer>> result) {
//
//