package round2;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magCount = new int[26];

        for (char c : magazine.toCharArray()) {
            magCount[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            magCount[c - 'a']--;
        }

        for (int n : magCount) {
            if (n < 0) {
                return false;
            }
        }

        return true;
    }
}
