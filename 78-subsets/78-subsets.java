class Solution {
   
    // brute force
    public List<List<Integer>> subsets(int[] nums) {
       
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        findSubsequences(temp, 0, nums, result);
        
        return result;
    }
    
    private  void findSubsequences(List<Integer> temp, int index, int[] nums,List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }   
        
        temp.add(nums[index]);
        findSubsequences(temp, index + 1, nums, result); // take      

        temp.remove(temp.size()-1);
        findSubsequences(temp, index + 1, nums, result); // not take
    }
}