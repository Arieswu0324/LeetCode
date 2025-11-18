import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EF {

    public static void main(String[] args) {
        //aba
        //output :ab, ba
        //abbc
        //ab, bc
        //a,aaa,abba
        //abbaa
        String str = "abba";
        List<String> subString = findSubString(str);
        subString.forEach(System.out::println);

    }

    //不含重复字符的最长子串
    public static List<String> findSubString(String str) {
        Map<Integer, List<String>> map = new HashMap<>();

        //aba
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < str.length(); j++) {
            int len = 0;
            Set<Character> set = new HashSet<>();
            for (int i = j; i < str.length(); i++) {
                if (!set.contains(str.charAt(i))) {
                    set.add(str.charAt(i));
                    if(i==str.length()-1){
                        len = i - j + 1;
                        String sub = str.substring(j, i+1);
                        map.computeIfAbsent(len, k -> new ArrayList<>()).add(sub);
                    }
                } else {
                    len = i - j;
                    String sub = str.substring(j, i);
                    map.computeIfAbsent(len, k -> new ArrayList<>()).add(sub);
                    break;
                }
            }
            max = Math.max(max, len);
        }

        return map.get(max);
    }

}


