class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        
        Map<Integer, Integer> map = new HashMap<>();
       
        for (int n : nums1) {
            if (!map.containsKey(n))
                map.put(n, 1);
            else
                map.put(n, map.get(n)  + 1);
        }
        
        for (int n : nums2) {
            if (map.containsKey(n))
                set.add(n);
        }
        
        int[] result = new int[set.size()];
        int id = 0;
        for (int n : set)
            result[id++] = n;
        
        return result;
    }
}