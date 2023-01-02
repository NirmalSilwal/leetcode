class Solution {
    // brute force
    public int pivotIndex1(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            // find sum before index i and after index i
            int curr = 0;
            for (int before = 0; before < i; before++) {
                curr += nums[before];
            }
            
            int tempSum = 0;
            for (int after = i + 1; after < nums.length; after++) {
                tempSum += nums[after];
            }
            
            if (curr == tempSum) return i;
        }

        return -1;
    }
    
    // sliding window approach with running sum
    public int pivotIndex(int[] nums) {
        
        int[] windowSum = new int[nums.length];
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            windowSum[i] = runningSum;
        }
        
        int finalSum = windowSum[windowSum.length - 1];
        int prev = 0;
        
        for (int i = 0; i < windowSum.length; i++) {
            if (i > 0) prev = windowSum[i - 1];
            if ((finalSum - windowSum[i]) == prev) return i;
        }
        
        return -1;
    }
    
    /*
    nums- [1,7,3,6,5,6]
    running sum - 1, 8, 11, 17, 22, 28
    nums - [1,2,3]
    running sum - 1, 3, 6
    nums - [2,1,-1]
    running sum - 2, 3, 2
    */
}