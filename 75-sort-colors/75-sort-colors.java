class Solution {
    
    // two pass solution
    /*
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
    */
    
    // one pass approach - dutch national flag algorithm
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, high, mid);
                high--;
            }
            else mid++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}