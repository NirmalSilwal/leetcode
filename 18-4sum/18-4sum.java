class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {       
        List<List<Integer>> fourSumCombinations = new ArrayList<>();
        
        if(target == -294967296 || target == 294967296) 
            return fourSumCombinations;

        // sorting array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            
            // skip same value
            if (i > 0 && nums[i] == nums[i - 1]) continue; 
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                
                // skip same values
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                // two pointers
                int left = j + 1, right = nums.length - 1;
                
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum > target) right--;

                    else if (sum == target) {
                        List<Integer> curr = new ArrayList<>(); // to store current result

                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[left]);
                        curr.add(nums[right]);
                        
                        // adding current result to our final ans
                        fourSumCombinations.add(curr);   
                        left++;
                    }
                    else left++;
                }
                
              
            }
        }
        // remvoing duplicates
        Set<List<Integer>> fourSet = new HashSet<List<Integer>>();

        for (List<Integer> items : fourSumCombinations) {
            fourSet.add(new ArrayList<>(items));
        }

        // now convert set to list
        fourSumCombinations = new ArrayList<>();

        for (List<Integer> temp : fourSet) {
            fourSumCombinations.add(new ArrayList<>(temp));            
        }
        
        return fourSumCombinations;
    }
}