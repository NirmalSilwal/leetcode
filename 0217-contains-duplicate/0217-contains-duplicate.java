class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) return false;
        Map<Integer, Integer> map = new HashMap(); // value, count
        
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Integer count : map.values()) {
            if (count > 1) return true;
        }

        return false;
    }
}