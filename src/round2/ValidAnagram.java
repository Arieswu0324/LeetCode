package round2;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram instance = new ValidAnagram();
        System.out.println(instance.isAnagram("anagram","nagaram"));
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] sArray = new int[26];
        int[] tArray = new int[26];

        for(char c: s.toCharArray()){
            sArray[c-'a']++;
        }

        for(char c: t.toCharArray()){
            tArray[c-'a']++;
        }

        for(int i = 0; i< 26; i++){
            if(sArray[i]!=tArray[i]){
                return false;
            }
        }

        return true;
    }
}
