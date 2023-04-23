import java.util.*;

public class Find3Numbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        List<Integer> list = new ArrayList<>(3);

        for (int j = 0; j < 3; j++) {
            int maxNo = Integer.MIN_VALUE;
            int maxIdx = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > maxNo && !list.contains(i)) {
                    maxNo = array[i];
                    maxIdx = i;
                }
            }
            if (!list.contains(maxIdx)) {
                list.add(maxIdx);
            }
        }
        return new int[]{array[list.get(2)], array[list.get(1)], array[list.get(0)]};
    }

    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            int val = c + key % 26;
            if (val > 122) {
                val = 96 + val % 122;
            }
            sb.append((char) val);
        }
        return sb.toString();
    }

    public static String runLengthEncoding(String string) {
        StringBuilder sb = new StringBuilder();
        char curChar = string.charAt(0);
        int count = 0;
        for (char c : string.toCharArray()) {
            if (count == 9 || curChar != c) {
                sb.append(count);
                sb.append(curChar);
                curChar = c;
                count = 0;
            }
            count++;
        }
        if (count != 0) {
            sb.append(count);
            sb.append(curChar);
        }
        return sb.toString();
    }

    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        if (string == null) {
            return -1;
        }

        for (char c : string.toCharArray()) {
            int firstIndex = string.indexOf(c);
            int lastIndex = string.lastIndexOf(c);

            if (firstIndex == lastIndex) {
                return firstIndex;
            }
        }

        return -1;
    }

    public static boolean generateDocument(String characters, String document) {
        // Write your code here.
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : characters.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char doc : document.toCharArray()) {
            if (!map.containsKey(doc)) {
                return false;
            } else {
                int count = map.get(doc) - 1;
                if (count < 0) {
                    return false;
                }
                map.put(doc, count);
            }
        }

        return true;
    }

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        // Write your code here.
        Set<String> set = new HashSet<>(Arrays.stream(words).toList());

        ArrayList<ArrayList<String>> list = new ArrayList<>();

        for (String word : words) {
            String rev = reverse(word);

            if (set.contains(rev)) {
                ArrayList<String> subList = new ArrayList<>();

                subList.add(word);
                subList.add(rev);

                list.add(subList);
            }
        }

        return list;
    }

    private String reverse(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            sb.append(c);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        // System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7})));
        // System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{1, 2, 3})));
        // System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{1, 1, 1})));

        //System.out.println(caesarCypherEncryptor("abc", 52));

        //  System.out.println(runLengthEncoding("AAAABBBBAACCC"));


        String chars = "Bste!hetsiog EAxpelrt x ";
        String doc = "AlgoExpert is the Best!";

        System.out.println(generateDocument(chars, doc));
    }
}
