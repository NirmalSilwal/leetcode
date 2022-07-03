class Solution {
    
    // 1st approach
    /*
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        boolean[] map = new boolean[nums.length];
        
        findPermutations(nums, new ArrayList<Integer>(), map, result);
        
        return result;
    }
    
    private void findPermutations(int[] nums, List<Integer> templist, boolean[] map, List<List<Integer>> result) {
        // when permutation if formed
        if (templist.size() == nums.length) {
            result.add(new ArrayList<>(templist));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            
            if (!map[i]) { // if current index is not taken
                map[i] = true;
                
                templist.add(nums[i]);
                
                findPermutations(nums, templist, map, result);
                
                // backtrack
                templist.remove(templist.size() - 1);
                map[i] = false;
            }
        }    
    }
    */
    // 2nd approach -  without extra space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        findPermutations2(nums, 0, result);
        
        return result;
    }
    
    private void findPermutations2(int[] nums, int index, List<List<Integer>> result) {
       
        if (index == nums.length) {
            // permutation is formed, as the result is itself in original array nums, we copy it and store in result
            List<Integer> templist = new ArrayList<>();
            
            for (int i = 0; i < nums.length; i++) {
                templist.add(nums[i]);
            }
            // now storing in result array
            result.add(new ArrayList<>(templist));
            return;
        }
        
        // scanning right indexes from current index
        for (int i = index; i < nums.length; i++) {
            
            swap(i, index, nums); // swap with yourself and swap with all elements in right indexes from you
            
            findPermutations2(nums, index + 1, result);
            
            swap(i, index, nums); // backtrack and swap previously swapped elements
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}