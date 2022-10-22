class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        findSubsets(set, nums, 0, new ArrayList<Integer>());
        return new ArrayList<>(set);
    }
    
    private void findSubsets(Set<List<Integer>> set, int[] nums, int pos, List<Integer> curr) {
        
        if (pos == nums.length) {
            set.add(new ArrayList<>(curr));
            return;
        }
       
        curr.add(nums[pos]);
        findSubsets(set, nums, pos + 1, curr);

        curr.remove(curr.size() - 1); // backtrack
        findSubsets(set, nums, pos + 1, curr);
    }
}