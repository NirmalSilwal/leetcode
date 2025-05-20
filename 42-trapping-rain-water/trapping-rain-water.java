class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int[] right = new int[n];

        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            currentMax = Math.max(currentMax, height[i]);
            left[i] = currentMax;
        }
        currentMax = Integer.MIN_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            currentMax = Math.max(currentMax, height[j]);
            right[j] = currentMax;
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(left[i], right[i]) - height[i];
        }
        return totalWater;
    }
}