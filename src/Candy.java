import java.util.Arrays;

public class Candy {
    public static int candy(int[] ratings) {
        int l = 1;
        int n = ratings.length;
        int[] candies= new int[n];
        Arrays.fill(candies,1);

        while(l<n){ // compare current and current -1 index
            if(ratings[l]>ratings[l-1]){
                candies[l] = candies[l-1] +1;
            }
            l++;
        }

        int r = n-2;
        while(r>=0){
            if(ratings[r]>ratings[r+1]){
                candies[r] = Math.max(candies[r+1]+1, candies[r]);
            }
            r--;
        }

        int total = 0;
        for(int i=0; i< n; i++){
            total+=candies[i];
        }

        return total;
    }


    public static void main(String[] args) {
        // Test case 1
        int[] ratings1 = {1, 0, 2};
        int result1 = candy(ratings1);
        System.out.println("Test Case 1: " + result1); // Expected output: 5

        // Test case 2
        int[] ratings2 = {1, 2, 2};
        int result2 = candy(ratings2);
        System.out.println("Test Case 2: " + result2); // Expected output: 4

        // Test case 3
        int[] ratings3 = {1, 3, 4, 5, 2};
        int result3 = candy(ratings3);
        System.out.println("Test Case 3: " + result3); // Expected output: 11
    }
}
