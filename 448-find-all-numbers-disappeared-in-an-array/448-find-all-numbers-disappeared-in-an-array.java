class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
// adding given elements in the hashset so we can later check from 1 to n and see if some element is missing
        for (int n : nums) {
            set.add(n);
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}