class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length < 2) return 1;
        
        int slow = 0, fast = 1; // index in nums
        
        while (fast < nums.length) {
            
            if (nums[slow] != nums[fast])  {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}