class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        helper(nums, result, 0, new ArrayList<Integer>());
        return new ArrayList<>(result);
    }
    
    private void helper(int[] nums, Set<List<Integer>> result, int index, List<Integer> curr) {
        
        if (curr.size() >= 2) {
            result.add(new ArrayList<>(curr));
        }
        
        // take and not take each element and explore paths
        for (int i = index; i < nums.length; i++) {

            if (curr.size() == 0 || nums[i] >= curr.get(curr.size() - 1)) {
                curr.add(nums[i]);
                helper(nums, result, i + 1, curr);  
                // backtrack
                curr.remove(curr.size() - 1);
            }
        }
    }
}