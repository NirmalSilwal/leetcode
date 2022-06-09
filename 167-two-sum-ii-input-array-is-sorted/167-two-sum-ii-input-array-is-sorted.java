class Solution {
    
    // brute force - O(N^2) time, O(1) space approach
    // this will give TLE
    /*
    public int[] twoSum(int[] numbers, int target) {
        
        int[] indices = new int[2]; // constant extra space of length 2
        
        for (int i = 0; i < numbers.length - 1; i++) {
            
            for (int j = i + 1; j < numbers.length; j++) {
                
                if (numbers[i] + numbers[j] == target) {
                    indices[0] = i + 1;
                    indices[1] = j + 1;
                }
            }
        }
        return indices;
    }
    */
    
    // 2nd approach - using the fact that it is sorted array
    public int[] twoSum(int[] numbers, int target) {
    	int[] indices = new int[2]; // constant extra space of length 2

    	int low = 0, high = numbers.length - 1;

    	while (low<high) {
    		while (numbers[low] + numbers[high] > target) {
    			high--;
    		}
    		while (numbers[low] + numbers[high]<target) {
    			low++;
    		}

    		if (numbers[low] + numbers[high] == target) {
    			indices[0] = low + 1;
    			indices[1] = high + 1;
    			break;
    		}
    	}
    	return indices;
    }
}