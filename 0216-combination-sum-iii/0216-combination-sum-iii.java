class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>> set = new HashSet<>();
        helper(set, k, n, new HashSet<Integer>());
        return new ArrayList<>(set);
    }
    
    private void helper(Set<List<Integer>> set, int k, int reqsum, Set<Integer> curr) {
        if (k == 0) {
            if (reqsum == 0) {
                set.add(new ArrayList<>(curr));
                return;
            } else {
                return;
            }
        }
        
        if (reqsum < 0) return;
        
        for (int num = 1; num <= 9; num++) {
            if (!curr.contains(num)) {
                curr.add(num);
                helper(set, k - 1, reqsum - num, curr);
                curr.remove(num);
            }
        }
    }
}