public class ReverseString {
    public static void reverse(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char t = chars[left];
            chars[left] = chars[right];
            chars[right] = t;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverse(chars);
        System.out.println(chars);
    }
}
