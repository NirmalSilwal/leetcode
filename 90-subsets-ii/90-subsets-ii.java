class Solution {
    
    // recursive solution with extra O(N) space
    /*
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findCombinations(nums, 0, new ArrayList<Integer>(), set);
        
        result.addAll(set);
        
        return result;
    }
    
    private void findCombinations(int[] nums, int index, ArrayList<Integer> tempList, Set<List<Integer>> set) {
        if (index == nums.length) {
            set.add(new ArrayList<>(tempList));
            return;
        }   
        
        // take current element
        tempList.add(nums[index]);
        findCombinations(nums, index + 1, tempList, set);
        
        // backtrack and remove taken element - not take step
        tempList.remove(tempList.size() - 1);
        
        findCombinations(nums, index + 1, tempList, set);
    }
    */
    
    // 2nd approach without using set
    
      public List<List<Integer>> subsetsWithDup(int[] nums) {        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
          
        findCombinations2(nums, 0, new ArrayList<Integer>(), result);
                
        return result;
    }
    
        private void findCombinations2(int[] nums, int index, ArrayList<Integer> templist, List<List<Integer>> result) {
            result.add(new ArrayList<>(templist));
            
            for (int i = index; i < nums.length; i++) {
                
                // ignore duplicates
                if (i > index && nums[i] == nums[i-1])
                    continue;
                
                templist.add(nums[i]);
                
                findCombinations2(nums, i+1, templist, result);
                
                templist.remove(templist.size() - 1);
            }
        }
    
}