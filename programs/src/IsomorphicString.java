import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (!smap.containsKey(sChar)) {
                smap.put(sChar, tChar);

            } else {
                char c = smap.get(sChar);
                if (c != tChar) {
                    return false;
                }
            }

            if (!tmap.containsKey(tChar)) {
                tmap.put(tChar, sChar);

            } else {
                char c = tmap.get(tChar);
                if (c != sChar) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
        //  System.out.println(isIsomorphic("foo", "bar"));
        // System.out.println(isIsomorphic("paper", "title"));
    }
}
