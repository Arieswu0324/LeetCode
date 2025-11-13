public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for (int[] trip : trips) {
            int i = trip[0];
            int j = trip[1];
            int val = trip[2];
            diff[i] += val;
            diff[j] -= val;
        }

        for (int i = 1; i < 1001; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > capacity) {
                return false;
            }
        }

        return diff[0] <= capacity;
    }
}
