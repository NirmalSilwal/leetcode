class Solution {
    
    // O(n) time, O(1) space
    public int missingNumber(int[] nums) {
        
        int givenSum = 0;
        
        for (int num : nums){
            givenSum += num;
        }
        
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        
        return expectedSum - givenSum;
    }
}