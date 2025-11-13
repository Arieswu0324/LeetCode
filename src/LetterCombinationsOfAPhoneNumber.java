import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterCombinationsOfAPhoneNumber {

    static List<List<Character>> res = new ArrayList<>();
    static List<Character> comb = new ArrayList<>();
    static Map<Character, List<Character>> map = new HashMap<>();
    public static List<String> letterCombinations(String digits){


        List<Character> nums = digits.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        int k = nums.size();
        if(k==0){
        }
        //init
        map.put('2',List.of('a','b','c'));
        map.put('3',List.of('d','e','f'));
        map.put('4', List.of('g','h','i'));
        map.put('5', List.of('j','k','l'));
        map.put('6', List.of('m','n','o'));
        map.put('7', List.of('p','q','r','s'));
        map.put('8', List.of('t','u','v'));
        map.put('9', List.of('w','x','y','z'));
        backtracking(k,nums,0);

       List<String> result = res.stream()
                .map(charList -> {
                    StringBuilder sb = new StringBuilder();
                    for (Character c : charList) {
                        sb.append(c);
                    }
                    return sb.toString();
                })
                .collect(Collectors.toList());

        if(!result.isEmpty()){
            return result;
        }else {
            return new ArrayList<>();
        }
    }

    private static void backtracking(int k, List<Character> digits, int startIndex){
        if(comb.size() == k){
            res.add(new ArrayList<>(comb));
            return;
        }

        Character cur= digits.get(startIndex);
        List<Character> ch = map.get(cur);
        for(int i = 0; i<ch.size(); i++){
            comb.add(ch.get(i));
            backtracking(k,digits, startIndex+1);
            comb.removeLast();
            }
        }


    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    }
