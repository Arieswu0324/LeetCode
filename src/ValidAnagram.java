import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] occurrences = new int[26];
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        for (int i = 0; i < sCharArray.length; i++) {
            int index = sCharArray[i] - 'a';
            occurrences[index]++;
        }

        for (int i = 0; i < tCharArray.length; i++) {
            int index = tCharArray[i] - 'a';
            occurrences[index]--;
        }

        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        return map.values().stream().noneMatch(val -> val != 0);
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "bca";
        System.out.println(isAnagram1(s, t));
    }
}
