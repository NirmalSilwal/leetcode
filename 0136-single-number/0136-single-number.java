class Solution {
    public int singleNumber(int[] nums) {
        
        // idea: XOR of two equal number is zero
        int xorvalue = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            xorvalue ^= nums[i];
        }

        return xorvalue;
    }
}