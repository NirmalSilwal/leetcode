class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>> set = new HashSet<>();
        combinations(set, k, n, new HashSet<Integer>());
        return new ArrayList<>(set);
    }
    
    private void combinations(Set<List<Integer>> set, int totalElements, int totalSum, Set<Integer> curr) {
        
        if (totalElements == 0) {
            if (totalSum == 0) {
                set.add(new ArrayList<>(curr));
                return;
            } else return;
        }
        
        if (totalSum < 0) return;
        
        for (int value = 1; value <= 9; value++) {
            if (!curr.contains(value)) {
                curr.add(value);
                combinations(set, totalElements - 1, totalSum - value, curr);
                curr.remove(value); // backtrack
            }
        }
    }
}