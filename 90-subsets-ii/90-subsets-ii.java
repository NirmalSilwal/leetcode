class Solution {
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
}