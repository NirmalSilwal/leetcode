class Solution {
    // 1st approach
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>> set = new HashSet<>();
        helper(set, k, n, new HashSet<Integer>());
        return new ArrayList<>(set);
    }
    
    private void helper(Set<List<Integer>> set, int totalNums, int requiredSum, Set<Integer> currset) {
        
        if (totalNums == 0) {
            if (requiredSum == 0) {
                set.add(new ArrayList<>(currset));
                return;
            } else
                return;
        }
        if (requiredSum < 0)
            return;
        
        for (int i = 1; i <= 9; i++) {
            if (!currset.contains(i)) {
                currset.add(i);
                helper(set, totalNums - 1, requiredSum - i, currset);
                currset.remove(i); // backtrack
            }
        }
    }
}