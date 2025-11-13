import java.util.HashMap;
import java.util.Map;

public class Ransom {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                int o = map.get(c);
                o--;
                if (o < 0) {
                    return false;
                }
                map.put(c, o);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct1(String ransomNote, String magazine){
        int[] dict = new int[26];
        for(char c: magazine.toCharArray()){
            dict[c-'a'] ++;
        }

        for(char c: ransomNote.toCharArray()){
            dict[c-'a'] --;
        }

        for(int i : dict){
            if(i<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct1("a", "b"));
        System.out.println(canConstruct1("aa", "ab"));
        System.out.println(canConstruct1("aa","aab"));
    }
}
