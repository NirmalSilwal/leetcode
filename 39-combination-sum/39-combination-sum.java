class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> combinations = new ArrayList<>();

        findAllCombinations(0, target, candidates, combinations, new ArrayList<>());
        
        return combinations;
    }
    
    private void findAllCombinations(int index, int target, int[] candidates, List<List<Integer>> combinations, List<Integer> answer) {
    
        if (index == candidates.length) {
            if (target == 0) { 
                combinations.add(new ArrayList<>(answer));
                return;
            } else
                return;
        }
        if (target < 0) return;

        if (candidates[index] <= target) {
            // include current index element
            answer.add(candidates[index]);
            findAllCombinations(index, target - candidates[index], candidates, combinations, answer);

            // exclude current index element
            answer.remove(answer.size() - 1); // backtrack            
        }
        
        findAllCombinations(index + 1, target, candidates, combinations, answer);
    }
}