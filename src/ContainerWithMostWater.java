public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;

    }
}
