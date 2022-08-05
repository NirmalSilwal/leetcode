class Solution {
    
    // 1st approach - brute force optimized with DP / prefix, suffix sum
    
    /*
    // O(N) time, O(N) space
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
    */
    
    // 2nd approach -  two pointer approach, O(N) time, O(1) space
    public int trap(int[] height) {
        
        int left = 0, right = height.length - 1;
        int water = 0;
        int leftMax = 0, rightMax = 0;
        
        while (left <= right) {
            
            if (height[left] <= height[right]) {
                
                if (height[left] > leftMax) { // then can't trap water here
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                
                left++;
            } else {
                
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                
                right--;
            }
        }
        
        return water;
    }
}