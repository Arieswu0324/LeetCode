package round2;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {
        AssignCookies instance = new AssignCookies();
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(instance.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;

        for (int j : s) {
            if (index < g.length && j >= g[index]) {
                index++;
            }
        }

        return index;
    }
}
