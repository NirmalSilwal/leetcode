class Solution {
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
}