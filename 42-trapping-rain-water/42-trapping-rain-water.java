class Solution {
    
    // 1st approach - brute force
    public int trap(int[] height) {

        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        // filling max left for all height
        int currentMax = Integer.MIN_VALUE;
        
        for (int h = 0; h < height.length; h++) {
            
            if (height[h] > currentMax) {
                currentMax = height[h];
            }
            left[h] = currentMax;
        }
        
        currentMax = Integer.MIN_VALUE;
        // right filling
        for (int h = height.length - 1; h >= 0; h--) {
            
            if (height[h] > currentMax) {
                currentMax = height[h];
            }
            right[h] = currentMax;
        }
        
        int total = 0;
        
        // computing total rains
        for (int i = 0; i < height.length; i++) {
            int capacity = Math.min(left[i], right[i]);
            total += capacity - height[i];
        }
        
        return total;
    }
}