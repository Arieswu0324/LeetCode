import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    List<String> res = new ArrayList<>();
    int pointSum = 0;
    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0, pointSum);
        return res;

    }

    private void backTracking(String s, int startIndex, int pointSum) {
        if (pointSum == 3) {
            String sub = s.substring(startIndex, s.length());
            if (isValidIP(sub)) {
                res.add(s);
                return;
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (isValidIP(sub)) {
                s = addDot(s, i + 1);
                pointSum++;
                backTracking(s, i + 2, pointSum);
                s = removeDot(s, i + 1);
                pointSum--;
            } else {
                break;//直接退出循环，因为此时不需再分割了
            }
        }
    }


    private boolean isValidIP(String s){
        if(s.isEmpty()){
            return false;
        }
        char[] ch = s.toCharArray();
        for(char c : ch){
            if (c > '9' || c<'0'){
                return false;
            }
        }

        if(s.length()>1 && s.startsWith("0")){
            return false;
        }
        if(Integer.parseInt(s)<0 || Integer.parseInt(s) >255){
            return false;
        }

        return true;
    }

    private String addDot(String s, int index){
        String left = s.substring(0, index);
        String right = s.substring(index, s.length());
        StringBuilder sb = new StringBuilder();
       return sb.append(left).append(".").append(right).toString();
    }

    private String removeDot(String s, int index){
        String left = s.substring(0, index);
        String right = s.substring(index+1, s.length());
        StringBuilder sb = new StringBuilder();
       return sb.append(left).append(right).toString();
    }

    public static void main(String[] args) {
        String s = "101023";
        RestoreIPAddresses instance = new RestoreIPAddresses();
        List<String> res = instance.restoreIpAddresses(s);
        res.forEach(System.out::println);
    }
}
