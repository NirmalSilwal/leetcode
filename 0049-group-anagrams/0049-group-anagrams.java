class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap();
        
        for (String curr : strs) {
            
            // storing count of each characters of current string
            int[] currCharCounts = new int[26];
            for (char ch : curr.toCharArray()) {
                currCharCounts[ch - 'a']++;
            }
            
            StringBuffer sb = new StringBuffer();
            for (int n : currCharCounts) {
                sb.append(n);
                sb.append("#"); // to make unique key for hashmap based on characters counts
            }
            
            String currentKey = sb.toString();
            
            if (!map.containsKey(currentKey)) {
                map.put(currentKey, new ArrayList<>());
            }
            
            map.get(currentKey).add(curr);
        }
        
        result.addAll(map.values());
        
        return result;
    }
}