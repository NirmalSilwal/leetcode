class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       
        int n = nums.length;
        int left = 0, windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            windowSum += nums[right];

            while (windowSum >= target) {
                int currentWindowSize = right - left + 1;
                minLength = Math.min(minLength, currentWindowSize);
                windowSum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}