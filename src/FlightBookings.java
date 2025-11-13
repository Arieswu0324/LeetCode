public class FlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];

        for(int[] booking: bookings){
            int i = booking[0]-1;
            int j = booking[1];
            int val = booking[2];
            diff[i]+=val;
            if(j<n) {
                diff[j] -= val;
            }
        }


        for(int i = 1; i<n; i++){
            diff[i]+=diff[i-1];
        }
        return diff;
    }
}
