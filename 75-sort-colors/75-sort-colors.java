class Solution {
    
    // two pass solution
    public void sortColors(int[] nums) {
        int[] frequency = new int[3]; // each index will hold count of their indices value in array
        
        for(int n : nums) {
            if (n == 0) {
                frequency[0]++;
            }  else if (n == 1) {
                frequency[1]++;
            } else {
                frequency[2]++;
            }
        }
        
        int currIndex = 0;
        int loopCount = frequency[0];
        
        for (int i = 0; i < loopCount; i++) {
            nums[i] = 0;
            currIndex++;
        }
        
        loopCount = currIndex + frequency[1];       
        for (int i = currIndex; i < loopCount; i++) {
            nums[i] = 1;
            currIndex++;
        }
        
        for (int i = currIndex; i < nums.length; i++) {
            nums[i] = 2;
            currIndex++;
        }
    }
}