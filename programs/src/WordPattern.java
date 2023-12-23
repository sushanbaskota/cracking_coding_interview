import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        // pattern length == s word length
        String[] sArr = s.split(" ");

        if (pattern.length() != sArr.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            String word = sArr[i];
            String mapWord = map.get(c);

            if (map.containsKey(c)) {
                if (!mapWord.equals(word)) {
                    return false;
                }
            } else {
                // make sure 2 or more pattern letters doesnt have same s word
                if (map.containsValue(word)) {
                    return false;
                }
                map.put(c, word);
            }
        }

        return true;
    }
}
