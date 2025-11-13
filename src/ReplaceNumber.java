public class ReplaceNumber {
    public static String replace(String s){
        char[] ch = s.toCharArray();
        StringBuffer res = new StringBuffer();
        for(char c: ch){
            if(c>='0'&&c<='9'){
                res.append("number");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(replace("a5b"));
    }
}
