class Solution {
    // using extra space
    public List<Integer> majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            if (!map.containsKey(n)) 
                map.put(n, 1);
            else {
                map.put(n, map.get(n) + 1);
            }
        }
        
        List<Integer> majority = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
            if (entries.getValue() > Math.floor(nums.length / 3)) {
                majority.add(entries.getKey());
            }
        }
        
        return majority;
    }
}