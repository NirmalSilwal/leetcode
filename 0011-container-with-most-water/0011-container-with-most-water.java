class Solution {
    public int maxArea(int[] height) {
        
        int water = 0;
        int start = 0, end = height.length - 1;
        
        while (start <= end) {
            
            if (height[start] <= height[end]) {
                int tempVol =  height[start] * (end - start);
                water = Math.max(water, tempVol);
                start++;
            } else {
                int currVol = height[end] * (end - start);
                water = Math.max(water, currVol);
                end--;
            }
        }
        return water;
    }
}