class Solution {
    
    // 2nd approach - accepted
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(candidates); // since we need our answer in sorted order - lexicographical order output
        
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        
        return ans;
    }
    
    
    private void findCombinations(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> currentAns) {
        if (target == 0) {
            ans.add(new ArrayList<>(currentAns));
            return;
        }     
        for (int i = index; i < candidates.length; i++) {
            
            // skip same element being picked twice
            if (i > index && candidates[i] == candidates[i-1]) 
                continue;
            
            if (candidates[i] > target)  // no solution
                break; 
            
            currentAns.add(candidates[i]); // add current element to our answer data structure
            
            findCombinations(i + 1, candidates, target - candidates[i], ans, currentAns);
            
            currentAns.remove(currentAns.size() - 1); // removing previously added element ~ backtrack step
        }           
    }

    
    // 1st approach - TLE solution
    
    /*
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(candidates);
        
        findCombinations1(0, candidates, target, set, new ArrayList<>());
        
        result.addAll(set);
        
        return result;
    }
    
    private void findCombinations1(int index, int[] candidates, int target,  Set<List<Integer>> set, List<Integer> ds) {
     
        if (index == candidates.length) {
            if (target == 0) {
                set.add(new ArrayList<>(ds));
            } 
            return;
        }
        
        if (target < 0) return; 
        
        if (candidates[index] <= target) {
            ds.add(candidates[index]);
            findCombinations1(index + 1, candidates, target - candidates[index], set, ds); // take
            ds.remove(ds.size() - 1);
        }
        
        findCombinations1(index + 1, candidates, target, set, ds);  // not take
    }
    */
    
}