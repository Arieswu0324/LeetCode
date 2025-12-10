package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        List<String> list = new ArrayList<>();
        for(String str : strings){
            str = str.trim();
            if(!str.isEmpty()){
                list.add(str);
            }
        }

        return String.join(" ", list.reversed());
    }
}
